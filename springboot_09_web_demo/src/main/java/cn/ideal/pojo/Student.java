package cn.ideal.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: Student
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/20 23:10
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String telephone;
    private Integer gender;
//    private Department department;
    private String department;
    private Date birth;
}
