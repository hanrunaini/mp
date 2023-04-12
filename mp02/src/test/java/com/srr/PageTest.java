package com.srr;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.srr.mapper.UserMapper;
import com.srr.pojo.User;
import org.apache.catalina.mbeans.UserMBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: PageTest
 * Package: com.srr
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 16:55
 * @Version 1.0
 */
@SpringBootTest
public class PageTest {
    @Autowired
    private UserMapper userMap;

    @Test
    void testselectPage() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        IPage<User> userPage = new Page<>(1, 3);
        //执行查询
        userMap.selectPage(userPage, lambdaQueryWrapper);
        System.out.println("当前页：:" + userPage.getCurrent());
        System.out.println("每页显示条数：：" + userPage.getSize());
        System.out.println("总页数：：：" + userPage.getPages());
        System.out.println("总条数：：：" + userPage.getTotal());
        System.out.println("数据：：：" + userPage.getRecords());
    }

    @Test
    void testPage1() {
       IPage<User> userPage = new Page<>(1,2);
       userMap.selectByName(userPage,"Mary");
        System.out.println("当前页：:" + userPage.getCurrent());
        System.out.println("每页显示条数：：" + userPage.getSize());
        System.out.println("总页数：：：" + userPage.getPages());
        System.out.println("总条数：：：" + userPage.getTotal());
        System.out.println("数据：：：" + userPage.getRecords());
    }
}
