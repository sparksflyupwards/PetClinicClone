package ca.gbc.comp3095.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Visit extends BaseEntity{
    @Column(name="date")
    private LocalDate date;
    @Column(name="description")
    private String description;
    @ManyToOne()
    @JoinColumn(name="pet_id")
    private Pet pet;


}
