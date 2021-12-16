package ca.gbc.comp3095.petclinic.services.springDataJPA;

import ca.gbc.comp3095.petclinic.model.Specialty;
import ca.gbc.comp3095.petclinic.repositories.SpecialtyRepository;
import ca.gbc.comp3095.petclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtiesSDJpaService implements SpecialtiesService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtiesSDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public Set<Specialty> findAll() {
        return (Set<Specialty>) specialtyRepository.findAll();
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
