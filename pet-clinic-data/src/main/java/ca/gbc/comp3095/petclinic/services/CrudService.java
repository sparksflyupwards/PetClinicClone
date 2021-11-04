package ca.gbc.comp3095.petclinic.services;

import ca.gbc.comp3095.petclinic.model.Owner;

import java.util.Set;

public interface CrudService <T, ID>    {
    T findById(ID id);
    T save(T object);
    Set<T> findAll();
    void delete(T object);
    void deleteById(ID id);
}
