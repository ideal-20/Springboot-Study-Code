package cn.ideal.mapper;

import cn.ideal.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/26 21:28
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {
    User queryUserByUid(Integer uid);

    User queryUserByUserName(String username);
}
