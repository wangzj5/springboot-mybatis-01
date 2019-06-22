package com.example.springbootmybatisdemo.service;

import com.example.springbootmybatisdemo.bean.User;
import com.example.springbootmybatisdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User Sel(Long id){
        return userMapper.getUserById(id);
    }
}
