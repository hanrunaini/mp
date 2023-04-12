package com.srr.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName srr_user
 */
@TableName(value ="srr_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private String id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;


}