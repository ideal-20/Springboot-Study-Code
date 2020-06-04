package cn.ideal.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Student
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/6/4 10:59
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer uid;
    private String username;
    private String password;
    private String roles;
}

