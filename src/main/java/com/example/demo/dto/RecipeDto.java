package com.example.demo.dto;

import com.example.demo.entity.TypeOfDish;
import com.example.demo.entity.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class RecipeDto {

//    private Integer id;

    @NotBlank(message = "Необходимо указать название")
    private String name;

    @NotBlank(message = "Необходимо указать описание")
    private String description;

    @NotBlank(message = "Необходимо указать время")
    private String time;

    private Integer calorie;
    private Integer protein;
    private Integer fat;
    private Integer carbohydrate;
    private Integer value;
    private String url_photo;
    private User user;
    private TypeOfDish type;
//
}
