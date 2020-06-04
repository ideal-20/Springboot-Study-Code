package cn.ideal;

import cn.ideal.mapper.UserMapper;
import cn.ideal.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot11SecurityMysqlApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.queryUserByUid(1);
        System.out.println(user);
    }

}
