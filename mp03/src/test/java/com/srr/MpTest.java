package com.srr;

import com.srr.pojo.User;
import com.srr.service.impl.UserServiceImpl;
import com.srr.service.impl.UserServiceImpl2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: MpTest
 * Package: com.srr
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 22:53
 * @Version 1.0
 */
@SpringBootTest
public class MpTest {

    @Autowired
    private UserServiceImpl userServiceImpl1;
    @Autowired
    private UserServiceImpl2 userServiceImpl2;

    @Test
    void test1() {
        User user1 = userServiceImpl1.getById("40744d30300f844d4e8c0738a6b555a5");
        System.out.println("user1 = " + user1);
    }

    @Test
    void test2() {
        User user2 = userServiceImpl2.getById(1L);
        System.out.println("user2 = " + user2);
    }
}
