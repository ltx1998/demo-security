package com.cold.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cold.entity.ResponseResult;
import com.cold.entity.User;

/**
 * @Author: LTX
 * @Date: 2022/6/11/0011
 */
public interface LoginService extends IService<User> {

    /**
     * 登录接口
     * @param user
     * @return
     */
    ResponseResult login(User user);

    ResponseResult logout();
}
