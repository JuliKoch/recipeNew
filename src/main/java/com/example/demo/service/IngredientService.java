package com.example.demo.service;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.User;
import com.example.demo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient insert(Ingredient ingredient)
    {
        return  ingredientRepository.saveAndFlush(ingredient);
    }
    public void delete(Ingredient ingredient)
    {

        ingredientRepository.delete(ingredient);
    }

    public List<Ingredient> find()
    {
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> findById(Integer id)
    {
        return ingredientRepository.findById(id);
    }

    public Ingredient findByName(String name)
    {
        return ingredientRepository.findByName(name);
    }




}