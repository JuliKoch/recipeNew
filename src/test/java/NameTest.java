import com.example.demo.entity.Ingredient;

import com.example.demo.service.IngredientService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeSearchNameTest {
    @Autowired
    private IngredientService ingredientService;
    @Test
    public void SearchName()
    {
        Ingredient ingredient=ingredientService.findById(9).orElse(new Ingredient());

        assertEquals("апельсин",ingredient.getName());

    }
}
