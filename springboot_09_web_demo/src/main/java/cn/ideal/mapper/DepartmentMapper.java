package cn.ideal.mapper;

import cn.ideal.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName: DepartmentMapper
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/21 14:22
 * @Version: 1.0
 */
@Mapper
public interface DepartmentMapper {

    public List<Department> queryAllDepartment();

    public Department queryDepartmentById(Integer id);
}
