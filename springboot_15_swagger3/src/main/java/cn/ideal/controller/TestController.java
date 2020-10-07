package cn.ideal.controller;

import cn.ideal.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/10/4 20:34
 * @Version: 1.0
 */
@Api(value = "测试接口value", tags = "测试接口Tags")
@RestController
@RequestMapping("test/")
public class TestController {

    @PostMapping("/testA")
    public String testA() {
        return "This is a test";
    }

    @ApiOperation(
            value = "用户信息查询方法Value",
            notes = "这是用户信息查询方法的注释说明",
            response = User.class,
            tags = {""})
    @GetMapping("/queryUser")
    public User queryUser() {
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        return user;
    }

    @ApiOperation(value = "用户登录方法", notes = "用户登录注释说明")
    @PostMapping("/login")
    public String login(@ApiParam(name = "username", value = "用户名", required = true) String username,
                        @ApiParam(name = "password", value = "密码", required = true) String password) {
        if ("123".equals(username) && "123".equals(password)) {
            return "登录成功";
        } else {
            return "登录失败";
        }
    }

}
