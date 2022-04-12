package practice.springframework.Repositories;

import org.springframework.data.repository.CrudRepository;
import practice.springframework.Models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
