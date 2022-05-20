package practice.springframework.Converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import practice.springframework.Commands.CategoryCommand;
import practice.springframework.Commands.IngredientCommand;
import practice.springframework.Commands.RecipeCommand;
import practice.springframework.Models.Recipe;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NoteCommandToNote noteConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, IngredientCommandToIngredient ingredientConverter, NoteCommandToNote noteConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.noteConverter = noteConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null)
            return null;
        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setDescription(source.getDescription());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setDirection(source.getDirection());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setImage(source.getImage());
        recipe.setNote(noteConverter.convert(source.getNote()));

        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories().forEach((CategoryCommand categoryCommand) -> recipe.getCategories().add(categoryConverter.convert(categoryCommand)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0) {
            source.getIngredients().forEach((IngredientCommand ingredientCommand) -> recipe.getIngredients().add(ingredientConverter.convert(ingredientCommand)));
        }

        return recipe;
    }
}
