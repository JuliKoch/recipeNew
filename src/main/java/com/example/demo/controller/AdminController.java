package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/admin/")
public class AdminController {
    @Autowired
    private UserService userService;

//    @PreAuthorize("hasRole('USER')")
//    @GetMapping(value = "user/{id}")
//    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Integer id) {
//        User user = userService.findById(id);
//
//        if (user == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
////        UserDto result= UserDto.toUser(user);
//
//
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
}
