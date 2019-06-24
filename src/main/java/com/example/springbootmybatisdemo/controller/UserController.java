package com.example.springbootmybatisdemo.controller;

import com.example.springbootmybatisdemo.bean.User;
import com.example.springbootmybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;
    //创建线程安全的hashmap
    static Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<>());
    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable Long id){

        return userService.Sel(id).toString();
    }
}
