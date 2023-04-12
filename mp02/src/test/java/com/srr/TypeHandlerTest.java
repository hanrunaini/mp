package com.srr;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.srr.enums.GenderEnum;
import java.util.HashMap;
import java.util.List;

import com.srr.mapper.UserMapper;
import com.srr.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: TypeHandlerTest
 * Package: com.srr
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 19:09
 * @Version 1.0
 */
@SpringBootTest
public class TypeHandlerTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void testHandler() {
        User user = new User();
//        user.setId("");
        user.setName("w5");
        user.setAge(30);
        user.setEmail("w5@qq.com");
        user.setStatus(1);
        user.setGender(GenderEnum.MAN);
        HashMap<String, String> map = new HashMap<>();
        map.put("tel","13345543070");
        map.put("phone","010-123456");
        user.setContact(map);
//        INSERT INTO srr_user ( id, username, age, email, status, gender, contact ) VALUES ( ?, ?, ?, ?, ?, ?, ? )
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);

    }

    @Test
    void testHandlerSelect() {
        LambdaQueryWrapper<User> lambdaQueryWrapper =new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId,"40744d30300f844d4e8c0738a6b555a5");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }
}
