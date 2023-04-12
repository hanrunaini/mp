package com.srr.service;

import com.srr.pojo.User;

import java.util.List;

/**
 * ClassName: UserServiceImpl
 * Package: com.srr.service
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 10:30
 * @Version 1.0
 */
public interface UserService {

    List<User> selectAll();
}
