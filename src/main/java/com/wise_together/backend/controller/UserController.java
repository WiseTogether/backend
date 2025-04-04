package com.wise_together.backend.controller;

import com.wise_together.backend.entity.User;
import com.wise_together.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

//    @GetMapping("/users")
//    public List<User> getUsers() {
//        return users;
//    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return service.add(user);
    }
}
