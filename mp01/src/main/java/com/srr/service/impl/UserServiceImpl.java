package com.srr.service.impl;

import com.srr.mapper.UserMapper;
import com.srr.pojo.User;
import com.srr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: UserServiceImpl
 * Package: com.srr.service.impl
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 10:31
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
