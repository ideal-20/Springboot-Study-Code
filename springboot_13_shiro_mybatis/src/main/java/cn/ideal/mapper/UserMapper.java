package cn.ideal.mapper;

import cn.ideal.pojo.Permission;
import cn.ideal.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/7/9 15:08
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {
    UserPojo queryUserByUsername(@Param("username") String username);

    Permission queryPermissionByUsername(@Param("username") String username);
}
