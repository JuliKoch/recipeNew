package com.example.demo.service;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Product;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.Unit;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product insert(Product product)
    {

        return  productRepository.saveAndFlush(product); //saveAndFlush
    }
    //delete id or user?
    public void delete(Product product)
    {

        productRepository.delete(product);
    }

    public List<Product> find()
    {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id)
    {

        return productRepository.findById(id);
    }

    public Product findByRecipe(Recipe recipe)
    {

        return productRepository.findByRecipe(recipe);
    }

    public Product findByIngredient(Ingredient ingredient)
    {

        return productRepository.findByIngredient(ingredient);
    }

    public Product findByUnit(Unit unit)
    {

        return productRepository.findByUnit(unit);
    }
    //quantity?

}
