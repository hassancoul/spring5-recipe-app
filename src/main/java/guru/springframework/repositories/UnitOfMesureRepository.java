package guru.springframework.repositories;

import guru.springframework.models.UnitOfMesure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMesureRepository extends CrudRepository<UnitOfMesure, Long> {

    Optional<UnitOfMesure> findByUnit(String unit);
}
