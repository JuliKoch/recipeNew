package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select p from Product p where p.ingredient=:ingredient")
    Product findByIngredient(@Param("ingredient")Ingredient ingredient);

    @Query("select p from Product p where p.recipe=:recipe")
    Product findByRecipe(@Param("recipe") Recipe recipe);

    @Query("select p from Product p where p.unit=:unit")
    Product findByUnit(@Param("unit") Unit unit );

}
