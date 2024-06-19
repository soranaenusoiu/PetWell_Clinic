package org.example.petwell_clinic.entity;

import jakarta.persistence.*;
import lombok.*;

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

    private Integer appointment_id;
    private String date;
    private String time;
    private String reason;
    private String diagnosis;
    private String treatment;
    private String invoice;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "veterinary_id")
    private Veterinary veterinary;


}
