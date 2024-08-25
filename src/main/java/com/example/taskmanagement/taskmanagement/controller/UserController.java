package com.example.taskmanagement.taskmanagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.taskmanagement.taskmanagement.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestParam String username, @RequestParam String password) {
        userService.registerUser(username, password);
    }
}
