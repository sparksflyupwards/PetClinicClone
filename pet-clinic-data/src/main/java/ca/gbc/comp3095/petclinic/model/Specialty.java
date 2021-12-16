package ca.gbc.comp3095.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Specialty extends BaseEntity{
    @Column(name="description")
    private String description;

   }
