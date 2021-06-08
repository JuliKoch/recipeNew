package com.example.demo.repository;

import com.example.demo.entity.Favorite;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Integer> {

    @Query("select f from Favorite f where f.user=:user")
    Favorite findByIdUser(@Param("user") User user);

    @Query("select f from Favorite f where f.recipe=:recipe")
    Favorite findByIdRecipe(@Param("recipe") Recipe recipe);

}