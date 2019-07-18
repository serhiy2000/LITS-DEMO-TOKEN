package com.lits.demo.controller;

import com.lits.demo.entity.User;
import com.lits.demo.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "save")
    public User saveUser (@RequestBody User user) {
        return userService.saveUser(user);
    }
}