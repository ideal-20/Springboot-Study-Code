package cn.ideal.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Department
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/20 22:48
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String dname;
}
