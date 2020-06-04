package cn.ideal.service;

import cn.ideal.mapper.UserMapper;
import cn.ideal.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/5/26 21:22
 * @Version: 1.0
 */
@Service
public class UserService<T extends User> implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.queryUserByUserName(username);
        if (username == null){
            throw  new UsernameNotFoundException("用户名不存在");
        }

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        String role = user.getRoles();
        if (StringUtils.isNotBlank(role)){
            authorityList.add(new SimpleGrantedAuthority(role.trim()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorityList);
    }
}
