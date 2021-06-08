package com.example.demo.dto;

import com.example.demo.entity.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserDto {


    @NotBlank(message = "Необходимо указать имя")
    private String login;

    @NotBlank(message = "Необходимо указать пароль")
    private String password;


}
