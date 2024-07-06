package org.example.petwell_clinic.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "pet_id")
    private Long id;

    private String species;
    private String breed;
    private String name;
    private int age;
    private double weight;

    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "pet")
    @JsonIgnore
    @JsonManagedReference
    private Set<Appointment> appointments = new HashSet<>();

}
