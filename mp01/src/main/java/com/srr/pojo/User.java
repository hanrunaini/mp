package com.srr.pojo;

import lombok.*;

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
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;


}
