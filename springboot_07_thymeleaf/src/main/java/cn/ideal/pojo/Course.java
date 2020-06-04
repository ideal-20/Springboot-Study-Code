package cn.ideal.pojo;

/**
 * @ClassName: Course
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/18 09:53
 * @Version: 1.0
 */
public class Course {
    private String name;
    private String teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
