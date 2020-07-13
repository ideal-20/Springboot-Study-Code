package cn.ideal.service;

import cn.ideal.pojo.Permission;
import cn.ideal.pojo.UserPojo;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/7/9 16:23
 * @Version: 1.0
 */
public interface UserService {

    UserPojo queryUserByUsername(String username);

    Permission queryPermissionByUsername(String username);

}
