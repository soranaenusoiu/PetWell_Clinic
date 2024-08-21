package org.example.petwell_clinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @Column(name="username")
    private String username;

    private String password;
    private Boolean enabled = true;


//    @OneToOne(mappedBy = "veterinary")
//    @JsonIgnore
//    @JsonManagedReference
//    private Set<Appointment> appointments = new HashSet<>();

}
