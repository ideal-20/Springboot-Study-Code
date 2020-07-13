package cn.ideal;

import cn.ideal.mapper.UserMapper;
import cn.ideal.pojo.Permission;
import cn.ideal.pojo.UserPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot13ShiroMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        UserPojo admin = userMapper.queryUserByUsername("admin");
        System.out.println(admin.toString());

        Permission permission = userMapper.queryPermissionByUsername("admin");

        System.out.println(permission.toString());

    }

}
