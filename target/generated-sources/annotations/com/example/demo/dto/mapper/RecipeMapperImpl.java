package com.example.demo.dto.mapper;

import com.example.demo.dto.RecipeDto;
import com.example.demo.entity.Recipe;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class RecipeMapperImpl implements RecipeMapper {

    @Override
    public RecipeDto toDto(Recipe recipe) {
        if ( recipe == null ) {
            return null;
        }

        RecipeDto recipeDto = new RecipeDto();

        recipeDto.setName( recipe.getName() );
        recipeDto.setDescription( recipe.getDescription() );
        recipeDto.setTime( recipe.getTime() );
        recipeDto.setCalorie( recipe.getCalorie() );
        recipeDto.setProtein( recipe.getProtein() );
        recipeDto.setFat( recipe.getFat() );
        recipeDto.setCarbohydrate( recipe.getCarbohydrate() );
        recipeDto.setValue( recipe.getValue() );
        recipeDto.setUrl_photo( recipe.getUrl_photo() );
        recipeDto.setUser( recipe.getUser() );
        recipeDto.setType( recipe.getType() );

        return recipeDto;
    }

    @Override
    public Recipe toEntity(RecipeDto recipeDto) {
        if ( recipeDto == null ) {
            return null;
        }

        Recipe recipe = new Recipe();

        recipe.setName( recipeDto.getName() );
        recipe.setDescription( recipeDto.getDescription() );
        recipe.setTime( recipeDto.getTime() );
        recipe.setCalorie( recipeDto.getCalorie() );
        recipe.setProtein( recipeDto.getProtein() );
        recipe.setFat( recipeDto.getFat() );
        recipe.setCarbohydrate( recipeDto.getCarbohydrate() );
        recipe.setValue( recipeDto.getValue() );
        recipe.setUrl_photo( recipeDto.getUrl_photo() );
        recipe.setUser( recipeDto.getUser() );
        recipe.setType( recipeDto.getType() );

        return recipe;
    }
}
