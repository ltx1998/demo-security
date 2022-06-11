package com.cold;

import com.cold.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: LTX
 * @Date: 2022/6/10/0010
 */
@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper UserMapper;

    @Test
    public void mapperTest(){
        System.out.println(UserMapper.selectList(null));
    }

    @Test
    public void PasswordTest(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String root = passwordEncoder.encode("root");
        System.out.println(passwordEncoder.matches("root", root));
        //System.out.println(root);

    }

}
