package com.cold.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cold.entity.LoginUser;
import com.cold.entity.User;
import com.cold.mapper.MenuMapper;
import com.cold.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author: LTX
 * @Date: 2022/6/10/0010
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);
        //判断 user可能为空
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或密码错误");
        }
        //TODO 根据用户查询的权限信息 添加到LoginUser中
        //List<String> list = new ArrayList<>(Arrays.asList("test","admin"));
        List<String> permsByUserId = menuMapper.selectPermsByUserId(user.getId());

        return new LoginUser(user,permsByUserId,null);
    }
}
