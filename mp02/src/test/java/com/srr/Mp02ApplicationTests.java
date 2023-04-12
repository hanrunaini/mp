package com.srr;

import com.srr.mapper.UserMapper;
import com.srr.pojo.User;
import com.srr.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mp02ApplicationTests {

    @Autowired
    private UserMapper userMap;
    @Autowired
    private UserService userService;
    @Test
    void test() {
        List<User> users = userMap.selectList(null);
        System.out.println("users = " + users);
    }

    @Test
    void testInsert() {
        User user = new User();
//        user.setId(6L);
        user.setName("Nike");
        user.setAge(33);
        user.setEmail("test6@powernode.com");

        int insert = userMap.insert(user);
        System.out.println("insert = " + insert);

    }

    @Test
    void testDeleteOne() {
        int i = userMap.deleteById(6L);
        System.out.println("i = " + i);
    }

    @Test
    void testUpdateById() {
        User user = new User();
//        user.setId(6L);
        user.setName("迈克");
        user.setAge(35);
        user.setEmail("mike@powernode.com");
        int i = userMap.updateById(user);
        System.out.println("i = " + i);
    }

    @Test
    void testSelectById() {
        User user = userMap.selectById(6L);
        System.out.println("user = " + user);
    }


    @Test
    void testInsertService() {
        User user = new User();
//        user.setId(7L);
        user.setName("张三");
        user.setAge(35);
        user.setEmail("zhangsan@powernode.com");
        boolean save = userService.save(user);
        System.out.println("save = " + save);

    }

    @Test
    void testDeeleteService() {
        boolean b = userService.removeById(7L);
        System.out.println("b = " + b);

    }

    @Test
    void testUpdateService() {
        User user = new User();
//        user.setId(6L);
        user.setAge(40);

        boolean b = userService.updateById(user);
        System.out.println("b = " + b);
    }

    @Test
    void testselectService() {
        List<User> users = userService.selectList();
        System.out.println("users = " + users);
    }

    @Test
    void testMethod() {
//        User tom = userMap.selectByName("Tom");
//        System.out.println("tom = " + tom);
    }

    @Test
    void testEq() {

    }
}
