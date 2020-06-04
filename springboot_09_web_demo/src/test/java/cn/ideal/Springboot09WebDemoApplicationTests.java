package cn.ideal;

import cn.ideal.mapper.DepartmentMapper;
import cn.ideal.mapper.StudentMapper;
import cn.ideal.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class Springboot09WebDemoApplicationTests {

//    @Autowired
//    private DepartmentMapper departmentMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void contextLoads() {
//        System.out.println("所有系别: " + departmentMapper.queryAllDepartment());
//        System.out.println("查询系别2: " + departmentMapper.queryDepartmentById(2));



//        System.out.println("所有学生: " + studentMapper.queryAllStudent());
//        System.out.println("查询学生2005: " + studentMapper.queryStudentById(2005));
//
//
//        Student student = new Student();
//        student.setName("麦克");
//        student.setGender(0);
//        student.setTelephone("19988888888");
//        student.setDepartment("物理系");
//        student.setBirth(new Date());
//
//        studentMapper.add(student);

        studentMapper.deleteById(2007);


    }

}
