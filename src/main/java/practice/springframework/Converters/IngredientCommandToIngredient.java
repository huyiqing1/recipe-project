package practice.springframework.Converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import practice.springframework.Commands.IngredientCommand;
import practice.springframework.Models.Ingredient;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure converter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure converter) {
        this.converter = converter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null)
            return null;
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        if (ingredient.getRecipe() != null)
            ingredient.setRecipeId(source.getRecipeId());
        ingredient.setDescription(source.getDescription());
        ingredient.setAmount(source.getAmount());
        ingredient.setUnitOfMeasure(converter.convert(source.getUnitOfMeasureCommand()));
        return ingredient;
    }
}
