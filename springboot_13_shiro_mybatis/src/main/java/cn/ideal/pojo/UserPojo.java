package cn.ideal.pojo;

import lombok.*;

/**
 * @ClassName: UserPojo
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/7/9 15:09
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserPojo {
    private int id;
    private String username;
    private String password;
    private Role role;
}
