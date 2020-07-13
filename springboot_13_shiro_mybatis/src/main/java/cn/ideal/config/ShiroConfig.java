package cn.ideal.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: ShiroConfig
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/7/9 16:59
 * @Version: 1.0
 */
@Configuration
public class ShiroConfig {

    /**
     * 配置 Shiro 过滤器
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        // 定义 shiroFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 关联 securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 自定义登录页面，如果登录的时候，就会执行这个请求，即跳转到登录页
        shiroFilterFactoryBean.setLoginUrl("/toLoginPage");
        // 指定成功页面
        shiroFilterFactoryBean.setSuccessUrl("/success");
        // 指定未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // 设置自定义 filter
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("anyRoleFilter", new MyRolesAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        // LinkedHashMap 是有序的，进行顺序拦截器配置
        Map<String, String> filterChainMap = new LinkedHashMap<>();

        // 配置可以匿名访问的地址，可以根据实际情况自己添加，放行一些静态资源等，anon 表示放行
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/img/**", "anon");
        filterChainMap.put("/js/**", "anon");
        // 指定页面放行，例如登录页面允许所有人登录
        filterChainMap.put("/toLoginPage", "anon");

        // 以“/user/admin” 开头的用户需要身份认证，authc 表示要进行身份认证
        filterChainMap.put("/user/admin/**", "authc");

        // 页面 -用户需要角色认证
        filterChainMap.put("/levelA/**", "anyRoleFilter[USER,ADMIN,SUPER_ADMIN]");
        filterChainMap.put("/levelB/**", "anyRoleFilter[ADMIN,SUPER_ADMIN]");
        filterChainMap.put("/levelC/**", "anyRoleFilter[SUPER_ADMIN]");

//        filterChainMap.put("/levelA/**", "roles[USER]");
//        filterChainMap.put("/levelB/**", "roles[ADMIN]");
//        filterChainMap.put("/levelC/**", "roles[SUPER_ADMIN]");

        // /user/admin/ 下的所有请求都要经过权限认证，只有权限为 user:[*] 的可以访问，也可以具体设置到 user:xxx
        filterChainMap.put("/user/admin/**", "perms[user:*]");

        // 配置注销过滤器
        filterChainMap.put("/logout", "logout");

        // 将Map 存入过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 配置安全管理器 SecurityManager
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        // 将自定义 Realm 加进来
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联 Realm
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    /**
     * 创建 realm 对象，需要自己定义
     *
     * @return
     */
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    /**
     * 整合 thymeleaf
     * @return
     */
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();

    }
}
