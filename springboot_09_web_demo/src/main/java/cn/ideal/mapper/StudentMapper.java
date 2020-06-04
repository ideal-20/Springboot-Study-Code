package cn.ideal.mapper;

import cn.ideal.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName: StudentMapper
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/21 15:39
 * @Version: 1.0
 */
@Mapper
public interface StudentMapper {

    void add(Student student);

    void deleteById(Integer id);

    void updateById(Student student);

    List<Student> queryAllStudent();

    Student queryStudentById(Integer id);




}
