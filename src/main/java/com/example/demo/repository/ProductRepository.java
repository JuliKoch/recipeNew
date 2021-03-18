package com.example.demo.repository;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Product;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select p from Product p where p.ingredient=:ingredient")
    Ingredient findByIngredient(@Param("ingredient")Ingredient ingredient);

    @Query("select p from Product p where p.recipe=:recipe")
    Ingredient findByRecipe(@Param("recipe") Recipe recipe);

}
