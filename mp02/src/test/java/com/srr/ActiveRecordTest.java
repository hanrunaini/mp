package com.srr;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.srr.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * ClassName: ActiveRecordTest
 * Package: com.srr
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 17:44
 * @Version 1.0
 */
@SpringBootTest
public class ActiveRecordTest {
    @Test
    void testInsert() {
        User user = new User();
//        user.setId("");
        user.setName("zhang");
        user.setAge(35);
        user.setEmail("zhang@qq.com");
        boolean insert = user.insert();
//        INSERT INTO srr_user ( id, username, age, email ) VALUES ( ?, ?, ?, ? )
        System.out.println("insert = " + insert);

    }

    @Test
    void testDelete() {
        User user = new User();
        user.setId("1c8bddcbabe774fa98d15503d98fb902");
        boolean b = user.deleteById();
        System.out.println("b = " + b);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId("1c8bddcbabe774fa98d15503d98fb902");
        user.setName("cheng5");
        user.setAge(100);
        boolean b = user.updateById();
        System.out.println(b);

    }

    @Test
    void testselect() {
        User user = new User();
//        SELECT id,username AS name,age,email FROM srr_user WHERE id=?
        user.setId("256b4b0d13641a2ec94366a17dcde996");
        User user1 = user.selectById();
        System.out.println(user1);
    }

    @Test
    void testList() {
        List<String> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Mary"), User::getId);
        System.out.println("list = " + list);
    }

    @Test
    void testList2() {
        List<String> mary = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Mary"), User::getName, user -> Optional.of(user.getName()).map(String::toLowerCase).ifPresent(user::setName));
        System.out.println("mary = " + mary);
    }

    @Test
    void testMap() {
        Map<String, User> map = SimpleQuery.keyMap(new LambdaQueryWrapper<User>(), User::getId);
        System.out.println("map = "+map);
    }

    @Test
    void testMap2() {
        Map<String, User> map = SimpleQuery.keyMap(new LambdaQueryWrapper<User>().eq(User::getId, 1), User::getId);
        System.out.println("map = " + map);
    }

    @Test
    void testMap3() {
        Map<String, String> map = SimpleQuery.map(new LambdaQueryWrapper<User>(), User::getId, User::getName);
        System.out.println("map = " + map);
    }

    @Test
    void testGroup() {
        Map<String, List<User>> map = SimpleQuery.group(new LambdaQueryWrapper<User>(), User::getName);
        System.out.println("map = " + map);
    }
}
