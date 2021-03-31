package com.example.demo.service;

import com.example.demo.entity.Recipe;
import com.example.demo.entity.TypeOfDish;
import com.example.demo.repository.TypeOfDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeOfDishService {

    @Autowired
    private TypeOfDishRepository typeOfDishRepository;

    public TypeOfDish insert(TypeOfDish typeOfDish)
    {

        return  typeOfDishRepository.saveAndFlush(typeOfDish); //saveAndFlush
    }
    //delete id or user?
    public void delete(TypeOfDish typeOfDish)
    {

        typeOfDishRepository.delete(typeOfDish);
    }

    public List<TypeOfDish> find()
    {

        return typeOfDishRepository.findAll();
    }

    public Optional<TypeOfDish> findById(Integer id)
    {

        return typeOfDishRepository.findById(id);
    }

    public TypeOfDish findByType(String type)
    {

        return typeOfDishRepository.findByType(type);
    }

}
