package com.example.springbootmybatisdemo.mapper;

import com.example.springbootmybatisdemo.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserById(Long id);
}
