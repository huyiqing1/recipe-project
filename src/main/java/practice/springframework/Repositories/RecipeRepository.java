package practice.springframework.Repositories;

import org.springframework.data.repository.CrudRepository;
import practice.springframework.Models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
