package cn.ideal.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/13 18:02
 * @Version: 1.0
 */
@Component
@PropertySource(value = "classpath:user.properties")
@ConfigurationProperties(prefix = "usertest")
public class User {
//    @Value("Tom")
//    @Value("${user1.name}")
    private String name;

//    @Value("20")
//    @Value("${user1.age}")
    private Integer age;

//    @Value("北京")
//    @Value("${user1.address}")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
