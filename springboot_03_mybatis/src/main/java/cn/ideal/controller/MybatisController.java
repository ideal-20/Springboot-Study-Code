package cn.ideal.controller;

import cn.ideal.domain.User;
import cn.ideal.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: MybatisController
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/9 18:57
 * @Version: 1.0
 */
@Controller
public class MybatisController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/queryAllUser")
    @ResponseBody
    public List<User> queryUser() {
        List<User> users = userMapper.queryAllUser();
        return users;
    }
}
