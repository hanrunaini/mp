package com.srr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.srr.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: UserMapper
 * Package: com.srr.mapper
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 10:49
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectByName(IPage<User> page, String name);

}
