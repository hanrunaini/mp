package com.srr.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.srr.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

/**
 * ClassName: User
 * Package: com.srr.pojo
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 10:18
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("srr_user")
@TableName(autoResultMap = true)
public class User extends Model<User> {
    //    @TableId(type = IdType.AUTO)//数据库ID自增, 该 类型请确保数据库设置了ID自增,否则无效
//    @TableId(type=IdType.INPUT)//用户输入ID,该类型可以通过自己注册自动填充插件进行填充
//    @TableId(type = IdType.ASSIGN_ID)// 分配ID 主键 类型为number或String 默认雪花算法
//    @TableId(type=IdType.NONE) //该 类型为款设置主键 类型(注解里等于跟随全局，全局里约等于input
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    @TableField("username")
    private String name;

    //    @TableField(select = false)
    private Integer age;
    private String email;


    //    @TableLogic(value = "1",delval = "0")
    private Integer status;

    private GenderEnum gender;

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Map<String, String> contact; //联系方式

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    private Integer version;

//    @TableField("`desc`")
//    private String desc;


//    @TableField(exist = false)
//    private Integer online;


}
