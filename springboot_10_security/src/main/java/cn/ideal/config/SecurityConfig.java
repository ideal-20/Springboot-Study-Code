package cn.ideal.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName: SecurityConfig
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/26 11:49
 * @Version: 1.0
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/levelA/**").hasRole("vip1")
//                .antMatchers("/levelB/**").hasRole("vip2")
//                .antMatchers("/levelC/**").hasRole("vip3")

        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/toLoginPage")
                .loginProcessingUrl("/login"); // 登陆表单提交请求

        http.csrf().disable();//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
        http.logout().logoutSuccessUrl("/");
        //记住我
        http.rememberMe();
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中定义，也可以在jdbc中去拿....
        //Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
        //要想我们的项目还能够正常登陆，需要修改一下configure中的代码。我们要将前端传过来的密码进行某种方式加密
        //spring security 官方推荐的是使用bcrypt加密方式。


        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("666")).roles("vip1", "vip2", "vip3")
                .and()
                .withUser("ideal-20").password(new BCryptPasswordEncoder().encode("666")).roles("vip1", "vip2")
                .and()
                .withUser("jack").password(new BCryptPasswordEncoder().encode("666")).roles("vip1");
    }
}
