package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getUser()
    {
        return userRepository.findAll().toString();
    }
//   @PostMapping
//    public String save(@RequestParam("login") String login,
//                       @RequestParam("password") String password)
//    {
//        User user= User.builder()
//                .login(login)
//                .password(password)
//                .build();
//        return userRepository.save(user).toString();
//
//    }
}
