package ca.gbc.comp3095.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name ="owners")
public class Owner extends Person{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<Pet>();
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;


    @Builder
    public Owner(String lastName, String firstName, Set<Pet> pets, String address, String city, String telephone) {
        super(lastName, firstName);
        this.pets = pets;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }
}
