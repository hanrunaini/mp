package com.srr;
import com.srr.enums.GenderEnum;

import com.srr.mapper.UserMapper;
import com.srr.pojo.User;
import org.apache.catalina.mbeans.UserMBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: EnumTest
 * Package: com.srr
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 18:55
 * @Version 1.0
 */
@SpringBootTest
public class EnumTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void testEnum() {
        User user = new User();
        user.setName("liu");
        user.setAge(29);
        user.setEmail("liu@qq.com");
        user.setStatus(1);
        user.setGender(GenderEnum.MAN);
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);

    }
}
