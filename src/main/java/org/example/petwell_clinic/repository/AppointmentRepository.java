package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
