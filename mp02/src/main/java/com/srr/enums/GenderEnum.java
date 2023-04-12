package com.srr.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * ClassName: GenderEnum
 * Package: com.srr.enums
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 18:50
 * @Version 1.0
 */
public enum GenderEnum {
    MAN(0, "男"), WOMAN(1, "女");

    @EnumValue
    private Integer gender;
    private String genderName;

    GenderEnum(Integer gender, String genderName) {
        this.gender = gender;
        this.genderName = genderName;
    }
}
