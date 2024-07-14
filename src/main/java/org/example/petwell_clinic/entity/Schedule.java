package org.example.petwell_clinic.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime stopTime;

    @ManyToOne
    @JoinColumn(name = "veterinary_id")
    //https://stackoverflow.com/questions/47948279/return-only-id-in-json-instead-full-entity-object
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//varianta 2    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator .class, property = "@id")

    private Veterinary veterinary;

}
