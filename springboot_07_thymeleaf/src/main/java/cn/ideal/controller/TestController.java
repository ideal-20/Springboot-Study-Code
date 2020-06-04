package cn.ideal.controller;

import cn.ideal.pojo.Course;
import cn.ideal.pojo.LoginUser;
import cn.ideal.pojo.Student;
import cn.ideal.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/17 22:03
 * @Version: 1.0
 */
@Controller
public class TestController {
    @RequestMapping("test")
    public String test(Model model){
        String hello = "Hello Thymeleaf";
        model.addAttribute("hello",hello);
        return "test.html";
    }

    @RequestMapping("testStudent")
    public String testStudent(Model model){
        Student stu = new Student();
        Course course = new Course();

        course.setName("JavaEE课程");
        course.setTeacher("杰克老师");

        stu.setName("张三");
        stu.setAge(25);
        stu.setCourse(course);

        model.addAttribute("student",stu);
        return "test.html";
    }

    @RequestMapping("testUser")
    public String testUser(Model model){
        User user1 = new User();
        user1.setNickname("飞翔的企鹅");
        user1.setAge(30);

        User user2 = new User();
        user2.setNickname("伤心小男孩");
        user2.setAge(25);

        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);

        model.addAttribute("userList",list);
        return "test.html";
    }

    @RequestMapping("testDate")
    public String testDate(Model model){
        model.addAttribute("currentTime",new Date());
        return "test.html";
    }

    @RequestMapping("/testLogin")
    public String testLogin(@ModelAttribute(value = "loginUser")LoginUser loginUser, ModelMap modelMap){

        String username = loginUser.getUsername();
        String password = loginUser.getPassword();

        System.out.println(username);
        System.out.println(password);

        if ("admin".equals(username) && "admin888".equals(password)){
            modelMap.addAttribute("msg","登陆成功");
            return "test.html";
        }
        modelMap.addAttribute("msg","登陆失败");
        return "test.html";
    }
}
