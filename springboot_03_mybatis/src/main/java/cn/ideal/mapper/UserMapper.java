package cn.ideal.mapper;

import cn.ideal.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/9 18:52
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {
    public List<User> queryAllUser();
}
