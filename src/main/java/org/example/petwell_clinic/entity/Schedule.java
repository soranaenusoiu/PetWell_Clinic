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
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int schedule_id;
    private String date;
    private String start_hour;
    private String end_hour;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "vaterinary_id")
    private Veterinary veterinary;

}
