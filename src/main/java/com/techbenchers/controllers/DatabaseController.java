package com.techbenchers.controllers;

import com.techbenchers.mongodb.document.User;
import com.techbenchers.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DatabaseController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/all")
    public List<User> getAllUsers() {

        System.out.println("Inside getAll method");
        return userRepository.findAll();
    }

}

