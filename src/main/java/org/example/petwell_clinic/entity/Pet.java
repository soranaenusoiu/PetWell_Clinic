package org.example.petwell_clinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int pet_id;
    private String species;
    private String breed;
    private String pet_name;
    private int pet_age;
    private double pet_weight;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "pet")
    private Set<Appointment> appointments = new HashSet<>();

}
