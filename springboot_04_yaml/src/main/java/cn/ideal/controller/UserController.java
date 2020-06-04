package cn.ideal.controller;

import cn.ideal.pojo.Student;
import cn.ideal.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/13 18:07
 * @Version: 1.0
 */
@Controller
public class UserController {
    @Autowired
    User user;

    @Autowired
    Student student;

    @RequestMapping("/testUser")
    @ResponseBody
    public String testUser(){
        return user.toString();
    }

    @RequestMapping("/testStudent")
    @ResponseBody
    public String testStudent(){
        return student.toString();
    }
}
