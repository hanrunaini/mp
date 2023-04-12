package com.srr;

import com.srr.mapper.UserMapper;
import org.apache.catalina.mbeans.UserMBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: LogicTest
 * Package: com.srr
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 18:35
 * @Version 1.0
 */
@SpringBootTest
public class LogicTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void testLogic() {
//        UPDATE srr_user SET status=0 WHERE id=? AND status=1
        int i = userMapper.deleteById("8");
        System.out.println("i = " + i);
    }
}

