package com.example.demo.controller;

import com.example.demo.entity.Recipe;
import com.example.demo.entity.TypeOfDish;
import com.example.demo.service.RecipeService;
import com.example.demo.service.TypeOfDishService;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller

public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private TypeOfDishService typeOfDishService;

    @Autowired
    private UserService userService;
//    private Recipe recipe;

    @GetMapping("recipe/new")
    public String newRecipe(Model model)
    {
        return "recipe/new";
    }
    @PostMapping("recipe")   
    public String create(@RequestParam String type,
                         @RequestParam String user,
                         @RequestParam String name)
    {

        Recipe recipe=new Recipe();
        recipe.setType(typeOfDishService.findByType(type));
        recipe.setUser(userService.findByLogin(user));
        recipe.setName(name);
        recipeService.insert(recipe);
        return "redirect:/recipe";
    }
//    @PostMapping("/recipe/new")
//    public String add(Recipe recipe) {
//        recipeService.insert(recipe);
//        return  "redirect:/";
//    }
//    @GetMapping("/recipe")
//    public String get1()
//    {
//
//        return "recipe";
//    }
}
