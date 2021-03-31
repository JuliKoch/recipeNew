package com.example.demo.repository;

import com.example.demo.entity.TypeOfDish;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfDishRepository extends JpaRepository<TypeOfDish,Integer> {

    @Query ("select t from TypeOfDish t where t.typeOfDish=:TypeOfDish")
    TypeOfDish findByType(@Param("TypeOfDish") String TypeOfDish);



}
