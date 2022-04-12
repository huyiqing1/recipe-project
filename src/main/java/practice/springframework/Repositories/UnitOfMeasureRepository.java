package practice.springframework.Repositories;

import org.springframework.data.repository.CrudRepository;
import practice.springframework.Models.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

}
