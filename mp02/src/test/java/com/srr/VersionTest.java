package com.srr;

import com.srr.mapper.UserMapper;
import com.srr.pojo.User;
import org.apache.catalina.mbeans.UserMBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: VersionTest
 * Package: com.srr
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 22:08
 * @Version 1.0
 */
@SpringBootTest
public class VersionTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testVersion() {
//        SELECT id,username,age,email,status,gender,contact,create_time,update_time,version FROM srr_user WHERE id=? AND status=1
        User user = userMapper.selectById("476a4853c9fc8f0f3f6ee1dddeb362eb");
        System.out.println("user的查询结果 = " + user);
        user.setName("Shen");
//        UPDATE srr_user SET username=?, age=?, email=?, gender=?, contact=?, update_time=?, version=? WHERE id=? AND version=? AND status=1
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);
    }

    @Test
    void testUpdate2() {
        User user1 = userMapper.selectById("40744d30300f844d4e8c0738a6b555a5");
        System.out.println("user1 = " + user1);



        User user2 = userMapper.selectById("40744d30300f844d4e8c0738a6b555a5");
        System.out.println("user2 = " + user2);
        user2.setName("shenrunrun2");
        userMapper.updateById(user2);

        user2.setName("chengying2");
        userMapper.updateById(user2);
    }
}
