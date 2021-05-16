package com.example.demo.dto.mapper;

import com.example.demo.dto.RecipeDto;
import com.example.demo.entity.Recipe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    RecipeDto toDto(Recipe recipe);
    Recipe toEntity(RecipeDto recipeDto);
}
