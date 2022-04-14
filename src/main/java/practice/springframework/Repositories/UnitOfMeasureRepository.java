package practice.springframework.Repositories;

import org.springframework.data.repository.CrudRepository;
import practice.springframework.Models.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByUom(String uom);
}
