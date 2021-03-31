package com.example.demo.service;

import com.example.demo.entity.Recipe;
import com.example.demo.entity.User;
import com.example.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe insert(Recipe recipe)
    {

        return  recipeRepository.saveAndFlush(recipe); //saveAndFlush
    }
    //delete id or user?
    public void delete(Recipe recipe)
    {

        recipeRepository.delete(recipe);
    }

    public List<Recipe> find()
    {

        return recipeRepository.findAll();
    }

    public Optional<Recipe> findById(Integer id)
    {

        return recipeRepository.findById(id);
    }

    public Recipe findByName (String name)
    {

        return recipeRepository.findByName(name);
    }

    public Recipe findByDescription(String descr)
    {
        return recipeRepository.findByDescription(descr);
    }

    public Recipe findByTime(String time)
    {
        return recipeRepository.findByTime(time);
    }

    public Recipe findByCalorie(Integer calorie)
    {
        return recipeRepository.findByCalorie(calorie);
    }

    public Recipe findByProtein(Integer protein)
    {
        return recipeRepository.findByProtein(protein);
    }

    public Recipe findByFat(Integer fat)
    {
        return recipeRepository.findByFat(fat);
    }

    public Recipe findByCarbohydrate (Integer carb)
    {
        return recipeRepository.findByCarbohydrate(carb);
    }

    public Recipe findByValue (Integer value)
    {
        return recipeRepository.findByValue(value);
    }

    //url?
    public Recipe findByUrlPhoto(String urlPhoto)
    {
        return recipeRepository.findByUrlPhoto(urlPhoto);
    }

    //typeofdish?

    //user?
}
