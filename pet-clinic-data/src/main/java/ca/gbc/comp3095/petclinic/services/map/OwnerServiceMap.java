package ca.gbc.comp3095.petclinic.services.map;

import ca.gbc.comp3095.petclinic.model.Owner;
import ca.gbc.comp3095.petclinic.services.CrudService;
import ca.gbc.comp3095.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);

    }

    @Override
    public Owner findByLastname(String lastName) {
        return null;
    }
}
