package practice.springframework.Repositories;

import org.springframework.data.repository.CrudRepository;
import practice.springframework.Models.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
