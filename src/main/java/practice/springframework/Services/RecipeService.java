package practice.springframework.Services;

import practice.springframework.Models.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
