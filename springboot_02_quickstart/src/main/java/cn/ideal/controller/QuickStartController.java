package cn.ideal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickStartController {

    @RequestMapping("/testPort")
    @ResponseBody
    public String test2(){
        return "springboot 端口9090 访问测试 起飞~";
    }

}
