package com.example.springbootmybatisdemo.bean;

import lombok.Data;

@Data
public class User {

    private Long id; // 用户的唯一标识
    private String name;
    private String email;
    private String userame; // 用户账号，用户登录时的唯一标识
    private String password; // 登录时密码

    private String avatar; // 头像图片地址

}
