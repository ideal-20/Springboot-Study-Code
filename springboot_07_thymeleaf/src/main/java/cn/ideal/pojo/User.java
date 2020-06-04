package cn.ideal.pojo;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/18 22:13
 * @Version: 1.0
 */
public class User {
    private String nickname;
    private Integer age;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }
}
