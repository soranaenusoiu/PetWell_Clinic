package org.example.petwell_clinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "invoices")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long invoiceId;
    private float sum;
    private boolean status;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

}
