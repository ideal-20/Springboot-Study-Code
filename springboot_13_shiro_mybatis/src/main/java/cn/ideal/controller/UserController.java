package cn.ideal.controller;

import cn.ideal.pojo.UserPojo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/7/9 17:19
 * @Version: 1.0
 */
@Controller
public class UserController {
    @RequestMapping("/user/queryAll")
    @ResponseBody
    public String queryAll() {
        return "这是 user/queryAll 方法";
    }

    @RequestMapping("/user/admin/add")
    @ResponseBody
    public String adminAdd() {
        return "这是 user/adminAdd 方法";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        // 由于是根据name参数获取的，我这里封装了一下
        UserPojo user = new UserPojo();
        user.setUsername(username);
        user.setPassword(password);

        // 创建出一个 Token 内容本质基于前台的用户名和密码（不一定正确）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 获取 subject 认证主体（这里也就是现在登录的用户）
        Subject subject = SecurityUtils.getSubject();
        try{
            // 认证开始，这里会跳转到自定义的 UserRealm 中
            subject.login(token);
            // 可以存储到 session 中
            request.getSession().setAttribute("user", user);
            return "views/success";
        }catch(Exception e){
            // 捕获异常
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("errorMsg", "兄弟，用户名或密码错误");
            return "views/login";
        }
    }
}
