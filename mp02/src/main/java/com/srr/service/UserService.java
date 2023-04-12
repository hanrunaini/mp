package com.srr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.srr.pojo.User;

import java.util.List;

/**
 * ClassName: UserService
 * Package: com.srr.service
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 10:49
 * @Version 1.0
 */
public interface UserService extends IService<User> {

    List<User> selectList();
}
