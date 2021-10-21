package com.example.demo.controller;



import com.example.demo.dto.RecipeDto;
import com.example.demo.dto.mapper.RecipeMapper;
import com.example.demo.entity.*;
import com.example.demo.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private TypeOfDishService typeOfDishService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private ProductService productService;
    @Autowired
    private RecipeMapper recipeMapper;

    @Autowired
    private IngredientService ingredientService;


    @GetMapping("/search/name")

    public String searchName( Model model, @Param(value = "name") String name)
    {
        model.addAttribute("recipe",recipeService.find(name));
        return "recipe/search/name";
    }

    @GetMapping("/search/ingredient")

    public String searchIngredient( Model model, @Param(value = "name") String name)
    {

        model.addAttribute("recipe",recipeService.findByIngredient(name));
        return "recipe/search/ingredient";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String addRecipePost(
            @Valid RecipeDto recipe,
            Principal principal,Product product,Ingredient ingredient) {

        recipe.setUser((User) principal);
        recipeService.insert(recipeMapper.toEntity(recipe));

        ingredientService.insert(ingredient);
            product.setIngredient(ingredient);
            product.setRecipe(recipeMapper.toEntity(recipe));

            productService.insert(product);
        return "redirect:/recipe";
    }

    @GetMapping("/add")
    public String addRecipeGet(Model model, RecipeDto recipe,
                               Ingredient ingredient,Product product){
        model.addAttribute("recipe", recipe);
        model.addAttribute("type",typeOfDishService.find());
        model.addAttribute("unit",unitService.find());
        model.addAttribute("products",product);

        model.addAttribute("ingredient", ingredient);
        return "/recipe/add";
    }

    }




