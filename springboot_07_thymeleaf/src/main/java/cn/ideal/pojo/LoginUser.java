package cn.ideal.pojo;

/**
 * @ClassName: LoginUser
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/19 10:37
 * @Version: 1.0
 */
public class LoginUser {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
