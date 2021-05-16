package com.example.demo.dto;

import com.example.demo.entity.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserDto {
    private Integer id;
    private String login;

    public User toUser()
    {
        User user=new User();
        user.setId(id);
        user.setLogin(login);
        return user;
    }
    public static UserDto fromUser(User user)
    {
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        return userDto;
    }

}
