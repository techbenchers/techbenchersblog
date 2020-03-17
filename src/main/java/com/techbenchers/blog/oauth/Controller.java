package com.techbenchers.blog.oauth;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;

@RestController
public class Controller {
//    @GetMapping("/")
//    public String helloWorld() {
//        return "Hello World";
//    }

    @GetMapping("/user")
    @ResponseBody
    public HashMap<String, String> user(Principal principal) throws JsonProcessingException {
        ParseJsonString parseJsonString = new ParseJsonString();
        return parseJsonString.parse(principal);
    }
}
