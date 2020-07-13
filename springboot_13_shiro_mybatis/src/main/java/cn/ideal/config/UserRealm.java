package cn.ideal.config;

import cn.ideal.pojo.UserPojo;
import cn.ideal.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: UserRealm
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/7/9 16:27
 * @Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名信息
        String username = (String) principalCollection.getPrimaryPrincipal();
        // 创建一个简单授权验证信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 给这个用户设置从 role 表获取到的角色信息
        authorizationInfo.addRole(userService.queryUserByUsername(username).getRole().getRoleName());
        //给这个用户设置从 permission 表获取的权限信息
        authorizationInfo.addStringPermission(userService.queryPermissionByUsername(username).getPermissionName());
        return authorizationInfo;
    }


    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 根据在接受前台数据创建的 Token 获取用户名
        String username = (String) authenticationToken.getPrincipal();

//        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
//        System.out.println(userToken.getPrincipal());
//        System.out.println(userToken.getUsername());
//        System.out.println(userToken.getPassword());

        // 通过用户名查询相关的用户信息（实体）
        UserPojo user = userService.queryUserByUsername(username);
        if (user != null) {
            // 存入 Session，可选
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
            // 密码认证的工作，Shiro 来做
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "userRealm");
            return authenticationInfo;
        } else {
            // 返回 null 即会抛异常
            return null;
        }
    }
}
