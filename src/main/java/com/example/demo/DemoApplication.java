package com.example.demo;


import com.example.demo.entity.*;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext= SpringApplication.run(DemoApplication.class, args);

//        RecipeRepository recipeRepository=applicationContext.getBean(RecipeRepository.class);
//        System.out.println(recipeRepository.findByIngredient(List.of("apple")));
        RecipeService recipeService =applicationContext.getBean(RecipeService.class);
        TypeOfDishService typeOfDishService =applicationContext.getBean(TypeOfDishService.class);
        UserService userService =applicationContext.getBean(UserService.class);
//        Recipe recipe=new Recipe();
//        recipe.setType(typeOfDishService.findByType("soup"));
//        recipe.setUser(userService.findByLogin("Ivanov"));
//        recipe.setName("cake");
//        recipeService.insert(recipe);
        System.out.println("ok");

    }

}
