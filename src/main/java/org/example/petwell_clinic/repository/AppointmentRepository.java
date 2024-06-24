package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Appointment;
import org.example.petwell_clinic.entity.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAppointmentByVeterinaryEqualsAndInitTimeAfterAndEndTimeBefore(
            Veterinary veterinary, LocalDateTime  initTime, LocalDateTime endTime);
}
