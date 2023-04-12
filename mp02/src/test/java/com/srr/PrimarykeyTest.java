package com.srr;

import com.srr.mapper.UserMapper;
import com.srr.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: PrimarykeyTest
 * Package: com.srr
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 16:15
 * @Version 1.0
 */
@SpringBootTest
public class PrimarykeyTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void testprimarykey_Auto() {
        User user = new User();
        user.setName("Mary");
        user.setAge(35);
        user.setEmail("mary@powernode.com");
//        INSERT INTO srr_user ( username, age, email ) VALUES ( ?, ?, ? )
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);

    }

    @Test
    void testPrimaryKey_Input() {
        User user = new User();
//        user.setId(9L);
        user.setName("xixi");
        user.setAge(5);
        user.setEmail("xixi@qq.com");
//        INSERT INTO srr_user ( id, username, age, email ) VALUES ( ?, ?, ?, ? )
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }

    @Test
    void testPrimaryKey_Assign_id() {
        User user = new User();
//        user.setId(0L);
        user.setName("chengxing4");
        user.setAge(28);
        user.setEmail("chengxing@qq.com");

        int insert = userMapper.insert(user);
//        INSERT INTO srr_user ( id, username, age, email ) VALUES ( ?, ?, ?, ? )
//==> Parameters: 1645706083399929857(Long), chengxing(String), 28(Integer), chengxing@qq.com(String)
        System.out.println("insert = " + insert);

    }
}
