package com.example.demo.service;
import com.example.demo.entity.Favorite;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.User;
import com.example.demo.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    public Favorite insert(Favorite favorite)
    {

        return  favoriteRepository.saveAndFlush(favorite); //saveAndFlush
    }
    //delete id or user?
    public void delete(Favorite favorite)
    {

        favoriteRepository.delete(favorite);
    }

    public List<Favorite> find()
    {
        return favoriteRepository.findAll();
    }

    public Optional<Favorite> findById(Integer id)
    {
        return favoriteRepository.findById(id);
    }

    public Favorite findByIdUser(User user)
    {
        return favoriteRepository.findByIdUser(user);
    }

    public Favorite findByIdRecipe(Recipe recipe)
    {
        return favoriteRepository.findByIdRecipe(recipe);
    }

}