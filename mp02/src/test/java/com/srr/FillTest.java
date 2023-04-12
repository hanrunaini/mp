package com.srr;
import com.srr.enums.GenderEnum;
import java.util.Date;
import java.util.HashMap;

import com.srr.mapper.UserMapper;
import com.srr.pojo.User;
import com.srr.service.UserService;
import org.apache.catalina.mbeans.UserMBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;

/**
 * ClassName: FillTest
 * Package: com.srr
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 19:31
 * @Version 1.0
 */
@SpringBootTest
public class FillTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void testUpdateAll() {
        User user = new User();
        user.setGender(GenderEnum.WOMAN);
        boolean update = userService.update(user, null);
//        UPDATE srr_user SET gender=?, update_time=? WHERE status=1
        System.out.println("update = " + update);
    }

    @Test
    void test1() {
        User user =new User();
//        user.setId("");
        user.setName("z6");
        user.setAge(26);
        user.setEmail("z6@qq.com");
        user.setStatus(1);
        user.setGender(GenderEnum.MAN);
        HashMap<String, String> map = new HashMap<>();
        map.put("tel","13345543070");
        map.put("phone","0554-6224169");
        user.setContact(map);
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);

    }

    @Test
    void testUpdate() {
        //3453eaff72cd90b9b40175e0ee08b038

        User user =new User();
        user.setId("3453eaff72cd90b9b40175e0ee08b038");
        user.setName("z66");
        user.setAge(266);
        user.setEmail("z6@qq.com");
        user.setStatus(1);
        user.setGender(GenderEnum.MAN);
        HashMap<String, String> map = new HashMap<>();
        map.put("tel","13345543070");
        map.put("phone","0554-6224169");
        user.setContact(map);
        int insert = userMapper.updateById(user);
        System.out.println("insert = " + insert);
    }
}
