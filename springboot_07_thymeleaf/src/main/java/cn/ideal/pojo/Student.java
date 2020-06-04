package cn.ideal.pojo;

/**
 * @ClassName: Student
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/18 09:50
 * @Version: 1.0
 */
public class Student {
    private String name;
    private Integer age;
    private Course course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course=" + course +
                '}';
    }
}
