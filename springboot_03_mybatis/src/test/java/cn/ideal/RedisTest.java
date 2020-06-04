package cn.ideal;

import cn.ideal.domain.User;
import cn.ideal.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName: RedisTest
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/9 19:38
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot03MybatisApplication.class)
public class RedisTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() throws JsonProcessingException {
        //从redis缓存中获得指定的数据
        String userLists = redisTemplate.boundValueOps("user.queryAllUser").get();
        //如果redis中没有数据的话
        if (null == userLists) {
            //查询数据库获得数据
            List<User> all = userMapper.queryAllUser();
            //转换成json格式字符串
            ObjectMapper om = new ObjectMapper();
            userLists = om.writeValueAsString(all);
            //将数据存储到redis中，下次在查询直接从redis中获得数据，不用在查询数据库
            redisTemplate.boundValueOps("user.queryAllUser").set(userLists);
            System.out.println("===============从数据库获得数据===============");
        } else {
            System.out.println("===============从redis缓存中获得数据===============");
        }

        System.out.println(userLists);

    }

}