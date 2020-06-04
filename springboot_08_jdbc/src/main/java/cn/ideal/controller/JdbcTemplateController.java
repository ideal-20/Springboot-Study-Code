package cn.ideal.controller;

import cn.ideal.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: JdbcTemplateController
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/20 16:24
 * @Version: 1.0
 */
@Controller
@RequestMapping("/jdbc")
public class JdbcTemplateController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/userList")
    @ResponseBody
    public List<Map<String, Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @RequestMapping("/userList2")
    public void userList2(){
        String sql = "select * from user";
        ArrayList<User> users = (ArrayList<User>) jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<User>(User.class));
        for (User user : users){
            System.out.println(user);
        }
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(){
        //插入语句，注意时间问题
        String sql = "insert into user(uid, username,password,nickname) values (NULL,'wangwu','888','王五昵称')";
        jdbcTemplate.update(sql);
        //查询
        return "添加用户成功";
    }

    //修改用户信息
    @RequestMapping("/updateUser/{uid}")
    @ResponseBody
    public String updateUser(@PathVariable("uid") int uid){
        //插入语句
        String sql = "update user set username=?,password=?,nickname=? where uid="+ uid;
        //数据
        String[] s = new String[3];
        s[0] = "jack";
        s[1] = "666";
        s[2] = "杰克";
        jdbcTemplate.update(sql,s);
        //查询
        return "修改用户信息成功";
    }

    //删除用户
    @RequestMapping("/deleteUser/{uid}")
    @ResponseBody
    public String delUser(@PathVariable("uid") int uid){
        //插入语句
        String sql = "delete from user where uid=?";
        jdbcTemplate.update(sql,uid);
        //查询
        return "删除用户成功";
    }






}
