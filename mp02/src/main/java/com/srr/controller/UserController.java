package com.srr.controller;

import com.srr.pojo.User;
import com.srr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: UserController
 * Package: com.srr.controller
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 10:49
 * @Version 1.0
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("selectList")
    public List<User> selectList(){
        return userService.selectList();
    }
}
