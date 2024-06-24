package org.example.petwell_clinic.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

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
    @Column(name="schedule_id")
    private Long scheduleId;

    private LocalDateTime startTime;
    private LocalDateTime stopTime;

    @ManyToOne
    @JoinColumn(name = "veterinary_id")
    private Veterinary veterinary;

}
