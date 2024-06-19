package org.example.petwell_clinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "veterinaries")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Veterinary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int veterinary_id;
    private String name;
    private String phone;
    private String mail;
    private String speciality;

    @OneToMany (mappedBy = "veterinary")
    private Set<Appointment> appointments = new HashSet<>();

    @OneToMany (mappedBy = "veterinary")
    private Set<Schedule> schedules = new HashSet<>();

}
