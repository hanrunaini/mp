package com.srr;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.srr.mapper.UserMapper;
import com.srr.pojo.User;
import com.srr.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * ClassName: QueryTest
 * Package: com.srr
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 11:51
 * @Version 1.0
 */
@SpringBootTest
public class QueryTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    void testEq() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "Jack");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println("user = " + user);
    }

    @Test
    void testEq1() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName, "Jack");
        User jack = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println("jack = " + jack);
    }

    @Test
    void testNull() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = null;
        lambdaQueryWrapper.eq(name != null, User::getName, name);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (username = ?)
//        SELECT id,username AS name,age,email FROM srr_user WHERE (username = ?)
//        User user = userMapper.selectOne(lambdaQueryWrapper);
//        SELECT id,username AS name,age,email FROM srr_user
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testAllEq() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName, "Tom");
        lambdaQueryWrapper.eq(User::getAge, 28);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (username = ? AND age - ?)
        User user = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println("user = " + user);
    }

    @Test
    void testeAllEq2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "Tom");
        map.put("age", null);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(map, true);

//        SELECT id,username AS name,age,email FROM srr_user WHERE (age = ? AND username = ?)
//        SELECT id,username AS name,age,email FROM srr_user WHERE (username = ?)
//        SELECT id,username AS name,age,email FROM srr_user WHERE (age IS NULL AND username = ?)
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testNe() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(User::getName, "Tom");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void tsetGt() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        Integer age = 18;
        queryWrapper.gt(User::getAge, age);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testEe() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        Integer age = 18;
        queryWrapper.ge(User::getAge, age);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testlt() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        Integer age = 30;
        queryWrapper.lt(User::getAge, age);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testle() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        Integer age = 30;
        queryWrapper.le(User::getAge, age);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testBetween() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.between(User::getAge, 18, 40);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (age BETWEEN ? AND ?)
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testNotBetween() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notBetween(User::getAge, 18, 20);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (age BETWEEN ? AND ?)
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testLike() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, "J");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (username LIKE ?)
//        Parameters: %J%(String)
        System.out.println("users = " + users);

    }

    @Test
    void testNotLike() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notLike(User::getName, "J");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (username NOT LIKE ?)
//                ==> Parameters: %J%(String)
        System.out.println("users = " + users);
    }

    @Test
    void testLikeLeft() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.likeLeft(User::getName, "e");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (username LIKE ?)
//         Parameters: %e(String)
        System.out.println("users = " + users);
    }

    @Test
    void testLikeRight() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        Preparing: SELECT id,username AS name,age,email FROM srr_user WHERE (username LIKE ?)
//                ==> Parameters: J%(String)
        lambdaQueryWrapper.likeRight(User::getName, "J");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testNull1() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.isNull(User::getName);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
//        Preparing: SELECT id,username AS name,age,email FROM srr_user WHERE (username IS NULL)
        System.out.println("users = " + users);
    }

    @Test
    void testisNotNull() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.isNotNull(User::getName);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (username IS NOT NULL)
        System.out.println("users = " + users);
    }

    @Test
    void testIn() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        SELECT id,username AS name,age,email FROM srr_user WHERE (id IN (?,?,?))
        lambdaQueryWrapper.in(User::getId, 1, 2, 3);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testIn1() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        lambdaQueryWrapper.in(User::getId, arrayList);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (username IN (?,?,?))
//        SELECT id,username AS name,age,email FROM srr_user WHERE (id IN (?,?,?))
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testNotIn() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        lambdaQueryWrapper.notIn(User::getId, arrayList);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testInsql() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.inSql(User::getAge, "18,20,22");
//        SELECT id,username AS name,age,email FROM srr_user WHERE (age IN (18,20,22))
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testInsql2() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.inSql(User::getAge, "select age from srr_user where age > 18");
//        SELECT id,username AS name,age,email FROM srr_user WHERE (age IN (select age from srr_user where age > 18))
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);

    }

    @Test
    void testNotinSql() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notInSql(User::getAge, "18,20,22");
//     SELECT id,username AS name,age,email FROM srr_user WHERE (age NOT IN (18,20,22))
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testNotinsql2() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notInSql(User::getAge, "select age from srr_user where age > 20");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testGroubBy() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.groupBy("age").select("age,count(*) as field_count");

//        SELECT age,count(*) as field_count FROM srr_user GROUP BY age
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println("maps = " + maps);
//        maps = [{field_count=1, age=18}, {field_count=2, age=20}, {field_count=1, age=28}, {field_count=2, age=40}]
    }

    @Test
    void testHaving() {
//        SELECT age,count(*) as field_count FROM srr_user GROUP BY age HAVING field_count>1
        QueryWrapper<User> queryWrap = new QueryWrapper<>();
        queryWrap.groupBy("age")
                .select("age,count(*) as field_count")
                .having("field_count>1");

        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrap);
        System.out.println("maps = " + maps);

    }

    @Test
    void testOrderByAsc() {
        LambdaQueryWrapper<User> queryWrap = new LambdaQueryWrapper<>();
        queryWrap.orderByAsc(User::getAge, User::getId);
//        SELECT id,username AS name,age,email FROM srr_user ORDER BY age ASC,id ASC
        List<User> users = userMapper.selectList(queryWrap);
        System.out.println("users = " + users);
    }

    @Test
    void testOrderByDesc() {
        LambdaQueryWrapper<User> queryWrap = new LambdaQueryWrapper<>();
        queryWrap.orderByDesc(User::getAge, User::getId);
        List<User> users = userMapper.selectList(queryWrap);
        System.out.println("users = " + users);
    }

    @Test
    void testOrderBy() {
        LambdaQueryWrapper<User> lambdaQueryWrappe = new LambdaQueryWrapper<>();
        lambdaQueryWrappe.orderBy(true, true, User::getAge);
        lambdaQueryWrappe.orderBy(true, false, User::getId);
        List<User> users = userMapper.selectList(lambdaQueryWrappe);
//        SELECT id,username AS name,age,email FROM srr_user ORDER BY age ASC,id DESC
        System.out.println("users = " + users);
    }

    //内嵌逻辑查询

    @Test
    void testFun() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.func(new Consumer<LambdaQueryWrapper<User>>() {
//            @Override
//            public void accept(LambdaQueryWrapper<User> userLambdaQueryWrapper) {
//
//            }
//        });
        lambdaQueryWrapper.func(lw -> {
            if (true) {
                lw.eq(User::getId, 1);
            } else {
                lw.ne(User::getId, 2);
            }
        });
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testAnd() {
        //逻辑查询
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.gt(User::getAge, 22).lt(User::getAge, 30);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (age > ? AND age < ?)
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testAnd1() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        Preparing: SELECT id,username AS name,age,email FROM srr_user WHERE (username = ? AND (age > ? OR age < ?))
        lambdaQueryWrapper.eq(User::getName, "Tom")
                .and(i -> i.gt(User::getAge, 26).or().lt(User::getAge, 22));
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testOr() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.lt(User::getAge, 20).or().gt(User::getAge, 26);
//        SELECT id,username AS name,age,email FROM srr_user WHERE (age < ? OR age > ?)
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testOr1() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName,"Tom").or(i->i.gt(User::getAge,22).lt(User::getAge,26));
//        SELECT id,username AS name,age,email FROM srr_user WHERE (username = ? OR (age > ? AND age < ?))
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testNested() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.nested(i->i.eq(User::getName,"Tom").ne(User::getAge,22));
//        SELECT id,username AS name,age,email FROM srr_user WHERE ((username = ? AND age <> ?))
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    //自定义条件查询

    @Test
    void testApply() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.apply("id = 1");
//        SELECT id,username AS name,age,email FROM srr_user WHERE (id = 1)
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testLast() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.last("limit 0,2");
//        SELECT id,username AS name,age,email FROM srr_user limit 0,2
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testExists() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.exists("select id from srr_user where age = 188");
//        SELECT id,username AS name,age,email FROM srr_user WHERE (EXISTS (select id from srr_user where age = 18))
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testNotExists() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notExists("select id from srr_user where age = 188");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void testSelect() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(User::getId,User::getName);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
//        SELECT id,username AS name FROM srr_user
        System.out.println("users = "+users);
    }
}
