package practice.springframework.Services;

import practice.springframework.Commands.RecipeCommand;
import practice.springframework.Models.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
