package cn.ideal.pojo;

import lombok.*;

/**
 * @ClassName: Permission
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/7/9 15:20
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Permission {
    private Integer id;
    private String permissionName;
    private Role role;
}
