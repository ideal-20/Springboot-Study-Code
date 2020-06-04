package cn.ideal;

import cn.ideal.domain.User;
import cn.ideal.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName: MybatisTest
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/9 19:21
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot03MybatisApplication.class)
public class MybatisTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryAllUser(){
        List<User> users = userMapper.queryAllUser();
        System.out.println(users);
    }
}
