package org.example.petwell_clinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="appointments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="appointement_id")
    private Long id;

    private LocalDateTime initTime;
    private LocalDateTime endTime;
    private String reason;
    private String diagnosis;
    private String treatment;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "veterinary_id")
    private Veterinary veterinary;


}
