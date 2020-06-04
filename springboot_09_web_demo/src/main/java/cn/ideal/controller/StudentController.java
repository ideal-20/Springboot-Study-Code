package cn.ideal.controller;

import cn.ideal.mapper.DepartmentMapper;
import cn.ideal.mapper.StudentMapper;
import cn.ideal.pojo.Department;
import cn.ideal.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: StudentController
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/22 17:06
 * @Version: 1.0
 */
@Controller
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @RequestMapping("/listStudent")
    public String list(Model model){
        List<Student> students = studentMapper.queryAllStudent();
        model.addAttribute("students",students);
        return "stus/list";
    }

    @GetMapping("/toAddStudentPage")
    public String toAddStudentPage(Model model){
//        List departmentList = new ArrayList();
//
//        List<Student> students = studentMapper.queryAllStudent();
//        for (Student student :students){
//            String department = student.getDepartment();
//            departmentList.add(department);
//        }
//
//        model.addAttribute("departments",departmentList);

        List<Department> departments = departmentMapper.queryAllDepartment();

        model.addAttribute("departments",departments);

        return "stus/add";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student){
        studentMapper.add(student);
        System.out.println(student);
        return "redirect:/listStudent";
    }


    @GetMapping("/toUpdateStudentPage/{id}")
    public String toAddStudentPage(@PathVariable("id")Integer id,Model model){

        Student student = studentMapper.queryStudentById(id);

        List<Department> departments = departmentMapper.queryAllDepartment();

        model.addAttribute("student",student);
        model.addAttribute("departments",departments);

        //回显数据
        return "stus/update";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(Student student){
        studentMapper.updateById(student);
        System.out.println(student.getBirth());
        return "redirect:/listStudent";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id")int id){
        studentMapper.deleteById(id);
        return "redirect:/listStudent";
    }



}
