package com.example.demo.controller;

import com.example.demo.entity.Unit;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UnitService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;











//    @GetMapping("/login")
//    public String login(Model model)
//    {
//        return "login";
//    }

//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
//    @PostMapping("/registration")
//    public String addUser(@ModelAttribute("userForm") @Valid User userForm,
//                          BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//        if (!userForm.getPassword().equals(userForm.getPassword())) {
//            model.addAttribute("passwordError", "Пароли не совпадают");
//            return "registration";
//        }
//        try {
//            userService.insert(userForm);
//        } catch (RuntimeException e) {
//            model.addAttribute("usernameError",
//                    "Пользователь с таким именем уже существует");
//            return "registration";
//        }
//        return "redirect:/";
//   }

//    @PostMapping("/registration")
//    public String addUser( @Valid User user,
//                          BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//        if (!user.getPassword().equals(user.getPassword())) {
//            model.addAttribute("passwordError", "Пароли не совпадают");
//            return "registration";
//        }
//        try {
//            userService.insert(user);
//        } catch (RuntimeException e) {
//            model.addAttribute("usernameError",
//                    "Пользователь с таким именем уже существует");
//            return "registration";
//        }
//        return "redirect:/";
//   }
}
