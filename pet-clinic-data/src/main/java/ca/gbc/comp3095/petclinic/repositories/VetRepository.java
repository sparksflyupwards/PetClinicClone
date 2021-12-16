package ca.gbc.comp3095.petclinic.repositories;

import ca.gbc.comp3095.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
