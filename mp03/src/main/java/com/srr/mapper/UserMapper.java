package com.srr.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.srr.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 * @description 针对表【srr_user】的数据库操作Mapper
 * @createDate 2023-04-11 21:35:10
 * @Entity com.srr.pojo.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}




