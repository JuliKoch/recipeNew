package com.example.demo.repository;

import com.example.demo.entity.Recipe;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {

//    @Query("select r from Recipe r where r.name=:name")
//    Recipe findByName(@Param("name") String name );

    @Query("select r from Recipe r where r.description=:description")
    Recipe findByDescription(@Param("description") String description );

    @Query("select r from Recipe r where r.time=:time")
    Recipe findByTime(@Param("time") String time );

    @Query("select r from Recipe r where r.calorie=:calorie")
    Recipe findByCalorie(@Param("calorie") Integer calorie );

    @Query("select r from Recipe r where r.protein=:protein")
    Recipe findByProtein(@Param("protein") Integer protein );

    @Query("select r from Recipe r where r.fat=:fat")
    Recipe findByFat(@Param("fat") Integer fat);

    @Query("select r from Recipe r where r.carbohydrate=:carbohydrate")
    Recipe findByCarbohydrate(@Param("carbohydrate") Integer carbohydrate);

    @Query("select r from Recipe r where r.value=:value")
    Recipe findByValue(@Param("value") Integer value);

    @Query("select r from Recipe r where r.url_photo=:url_photo")
    Recipe findByUrlPhoto(@Param("url_photo") String url_photo);

    @Query(value = "select r.* from cookbook.recipe r inner join cookbook.product p on r.id_recipe = p.id_recipe\n" +
            "    inner join cookbook.ingredient i on p.id_ingredient = i.id_ingredient\n" +
            "    where i.ingredient in ?1", nativeQuery = true)
    List<Recipe> findAll( String[] ingredient);

    @Query(value = "select r.* from cookbook.recipe r where position(lower(?1) in (lower(concat(r.name))))<>0", nativeQuery = true)
    List<Recipe> findAll( String names);


}
