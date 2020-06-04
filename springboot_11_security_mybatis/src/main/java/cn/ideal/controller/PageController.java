package cn.ideal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: PageController
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/26 10:56
 * @Version: 1.0
 */
@Controller
public class PageController {

    @RequestMapping({"/", "index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/about")
    public String toAboutPage() {
        return "redirect:http://www.ideal-20.cn";
    }

    @RequestMapping("/toLoginPage")
    public String toLoginPage() {
        return "views/login";
    }

    @RequestMapping("/levelA/{name}")
    public String toLevelAPage(@PathVariable("name") String name) {
        System.out.println(name);
        return "views/L-A/" + name;
    }

    @RequestMapping("/levelB/{name}")
    public String toLevelBPage(@PathVariable("name") String name) {
        return "views/L-B/" + name;
    }

    @RequestMapping("/levelC/{name}")
    public String toLevelCPage(@PathVariable("name") String name) {
        return "views/L-C/" + name;
    }
}
