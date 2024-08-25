package com.example.taskmanagement.taskmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.taskmanagement.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.taskmanagement.model.User;

@Configuration
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            if (userRepository.findByUsername("admin") == null) {
                User user = new User(null, null, null, null);
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("password123"));
                userRepository.save(user);
            }
        };
    }
}
