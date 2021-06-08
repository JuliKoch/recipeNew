package com.example.demo.controller;


import com.example.demo.dto.RecipeDto;
import com.example.demo.dto.mapper.RecipeMapper;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.TypeOfDish;
import com.example.demo.entity.User;
import com.example.demo.service.RecipeService;
import com.example.demo.service.TypeOfDishService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private TypeOfDishService typeOfDishService;

    @Autowired
    private RecipeMapper recipeMapper;

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
                                Principal principal) {
        recipe.setUser((User) principal);
        recipeService.insert(recipeMapper.toEntity(recipe));
        return "redirect:/recipe";
    }
    @GetMapping("/add")
    public String addRecipeGet(Model model, RecipeDto recipe){
        model.addAttribute("recipe", recipe);
        model.addAttribute("typeOfDish",typeOfDishService.find());
        return "/recipe/add";
    }
//
//    @GetMapping("/search")
//    public List<Recipe> search()
//    {
//        return recipeService.find();
//    }



//    private Recipe recipe;

//    @GetMapping("recipe/new")
//    public String newRecipe(Model model)
//    {
//        return "recipe/new";
//    }
//    @PostMapping("recipe")
//    public String create(@RequestParam String type,
//                         @RequestParam String user,
//                         @RequestParam String name)
//    {
//
//        Recipe recipe=new Recipe();
//        recipe.setType(typeOfDishService.findByType(type));
//        recipe.setUser(userService.findByLogin(user));
//        recipe.setName(name);
//        recipeService.insert(recipe);
//        return "redirect:/recipe";
//    }
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
