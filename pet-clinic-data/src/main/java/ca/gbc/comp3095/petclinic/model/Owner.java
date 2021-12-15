package ca.gbc.comp3095.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person{

    private Set<Pet> pets = new HashSet<Pet>();

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
