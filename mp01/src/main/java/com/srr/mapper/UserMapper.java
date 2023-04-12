package com.srr.mapper;

import com.srr.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: UserMapper
 * Package: com.srr.mapper
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 10:22
 * @Version 1.0
 */

@Mapper
public interface UserMapper {

    public List<User> selectAll();
}
