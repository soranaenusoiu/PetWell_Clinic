package org.example.petwell_clinic.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long owner_id;
    private String name;
    private String phone;
    private String email;
    private String address;

    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();



}
