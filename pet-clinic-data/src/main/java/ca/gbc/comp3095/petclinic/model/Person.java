package ca.gbc.comp3095.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;


    public Person(Long id, String lastName, String firstName) {
        super(id);
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Person(String lastName, String firstName) {
    }
}
