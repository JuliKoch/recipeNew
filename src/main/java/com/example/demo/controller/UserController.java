package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.mapper.UserMapper;
;
import com.example.demo.entity.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleService roleService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model, UserDto user) {
        model.addAttribute("user", user);
        return "user/registration";
    }


    @PostMapping("/registration")
    public String addUser(Model model,@Valid UserDto user,
                          BindingResult result) {
        Optional<User> existing = userService.findByLogin(userMapper.toEntity(user).getLogin());
        if (existing.isPresent())
            result.rejectValue("login",null, "Такой пользователь существует!");
        if (result.hasErrors())
            return "user/error";
            userService.insert(userMapper.toEntity(user));
            return "redirect:/user/registration?success";
        }


}









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
