package com.srr.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.srr.pojo.User;
import com.srr.service.UserService;
import com.srr.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【srr_user】的数据库操作Service实现
* @createDate 2023-04-11 21:35:10
*/
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




