package com.example.demo.repository;


import com.example.demo.entity.Favorite;
import com.example.demo.entity.Ingredient;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {

    @Query("select i from Ingredient i where i.ingredient=:ingredient")
    Ingredient findByName(@Param("ingredient") String ingredient);
}