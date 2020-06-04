package cn.ideal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StartController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "springboot 访问测试，起飞，飞飞飞飞 ~ ~ ~";
    }

}