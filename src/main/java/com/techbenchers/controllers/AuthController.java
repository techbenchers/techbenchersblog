package com.techbenchers.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.techbenchers.mongodb.document.User;
import com.techbenchers.mongodb.repository.UserRepository;
import com.techbenchers.utils.JsonUtil;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;

@RestController
public class AuthController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/auth/user")
    @ResponseBody
    public HashMap<String, String> user(Principal principal) throws JsonProcessingException {
        JsonUtil parseJsonString = new JsonUtil();
        HashMap<String, String> userData = parseJsonString.parse(principal);
        try {
            String userName = userData.get("user_name");
            String userID = userData.get("user_id");
            String email = userData.get("email");
            User user = new User(userID, userName, email);
            repository.save(user);

        } catch (Exception ex) {
            System.out.println("Error in parsing user data object");
        }

        return userData;
    }
}
