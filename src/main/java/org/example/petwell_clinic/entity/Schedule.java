package org.example.petwell_clinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "schedules")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long schedule_id;
    private Date date;
    private Time start_time;
    private Time end_time;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "vaterinary_id")
    private Veterinary veterinary;

}
