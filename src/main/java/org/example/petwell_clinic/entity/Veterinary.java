package org.example.petwell_clinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@EqualsAndHashCode
public class Veterinary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="veterinary_id")
    private Long id;

    private String name;
    private String phone;
    private String mail;
    private String speciality;

    @OneToMany(mappedBy = "veterinary")
    @JsonIgnore
    @JsonManagedReference
    private Set<Appointment> appointments = new HashSet<>();

    @OneToMany(mappedBy = "veterinary")
    @JsonIgnore
    @JsonManagedReference
    private Set<Schedule> schedules = new HashSet<>();

}
