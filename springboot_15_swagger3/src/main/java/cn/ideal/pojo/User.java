package cn.ideal.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/10/6 15:47
 * @Version: 1.0
 */
@ApiModel(value = "用户类", description = "这是一个描述XX系统的用户类")
public class User {
    @ApiModelProperty(value = "姓名", example = "张三")
    private String name;
    @ApiModelProperty(value = "年龄", example = "20")
    private Integer age;

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


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
