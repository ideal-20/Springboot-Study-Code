package cn.ideal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/22 10:27
 * @Version: 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        //具体业务
        if (!StringUtils.isEmpty(username) && "666".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:main.html";
        }else{
            //登录失败
            model.addAttribute("errorMsg","用户名或密码错误");
            return "index";
        }

    }

    @RequestMapping("logout")
    public String deleteStudent(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
