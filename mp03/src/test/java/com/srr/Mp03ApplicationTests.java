package com.srr;

import com.srr.mapper.UserMapper;
import com.srr.pojo.User;
import com.srr.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mp03ApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Test
    void testMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println("users = " + users);
    }

    @Test
    void testUserService() {
        List<User> users = userMapper.selectList(null);
        System.out.println("users = " + users);
    }
}
