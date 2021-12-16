package ca.gbc.comp3095.petclinic.repositories;

import ca.gbc.comp3095.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
