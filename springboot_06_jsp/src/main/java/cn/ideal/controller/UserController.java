package cn.ideal.controller;

import cn.ideal.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/17 09:21
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/list")
    public String list(Model model) {
        System.out.println("查询所有");

        User u1 = new User();
        u1.setUsername("Steven");
        u1.setAge(20);
        u1.setAddress("北京");

        User u2 = new User();
        u2.setUsername("Jack");
        u2.setAge(30);
        u2.setAddress("上海");

        List<User> users = new ArrayList<User>();

        users.add(u1);
        users.add(u2);

        model.addAttribute("users", users);
        return "list";
    }

}
