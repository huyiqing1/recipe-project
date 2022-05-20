package practice.springframework.Converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import practice.springframework.Commands.RecipeCommand;
import practice.springframework.Models.Category;
import practice.springframework.Models.Ingredient;
import practice.springframework.Models.Recipe;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NoteToNoteCommand noteConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConverter, IngredientToIngredientCommand ingredientConverter, NoteToNoteCommand noteConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.noteConverter = noteConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null)
            return null;
        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setServings(source.getServings());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setUrl(source.getUrl());
        recipeCommand.setDirection(source.getDirection());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setImage(source.getImage());
        recipeCommand.setNote(noteConverter.convert(source.getNote()));

        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories().forEach((Category category) -> recipeCommand.getCategories().add(categoryConverter.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0) {
            source.getIngredients().forEach((Ingredient ingredient) -> recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient)));
        }
        return recipeCommand;
    }
}
