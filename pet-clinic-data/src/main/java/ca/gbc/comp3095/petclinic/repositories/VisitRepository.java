package ca.gbc.comp3095.petclinic.repositories;

import ca.gbc.comp3095.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
