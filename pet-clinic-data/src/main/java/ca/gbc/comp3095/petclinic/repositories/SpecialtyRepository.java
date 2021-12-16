package ca.gbc.comp3095.petclinic.repositories;

import ca.gbc.comp3095.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
