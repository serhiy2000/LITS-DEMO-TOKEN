package com.lits.demo.controller;

import com.lits.demo.entity.User;
import com.lits.demo.service.UserAuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/api")
public class UserAuthController {

    private UserAuthService userAuthService;

    @Autowired
    public UserAuthController(UserAuthService userAuthService){
        this.userAuthService = userAuthService;
    }

    @PostMapping(value = "/login")
    @ApiOperation("auth")
    public ResponseEntity<?> auth(@RequestBody User user){
        System.out.println("user.getUsername() from UserAuthController (the same as in POST command): "+user.getUsername()); // here works. userName = is the same as in POST request
        return ResponseEntity.ok(userAuthService.auth(user.getUsername(), user.getPassword()));
    }
}
