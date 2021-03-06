package ca.gbc.comp3095.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vets_specialties" , joinColumns = @JoinColumn(name="vet_id")
        , inverseJoinColumns = @JoinColumn(name="specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();

    @Builder
    public Vet(Long id, String lastName, String firstName, Set<Specialty> specialties) {
        super(id, lastName, firstName);
        this.specialties = specialties;
    }
}
