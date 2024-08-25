package com.example.taskmanagement.taskmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.taskmanagement.taskmanagement.model.User;
import com.example.taskmanagement.taskmanagement.repository.UserRepository;

@Service
public class UserService {

     @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

   

    public void registerUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(null, username, password, encodedPassword);
        user.setUsername(username);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
}