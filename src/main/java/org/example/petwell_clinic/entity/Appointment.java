package org.example.petwell_clinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long appointment_id;
    private Date date;
    private Time time;
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
