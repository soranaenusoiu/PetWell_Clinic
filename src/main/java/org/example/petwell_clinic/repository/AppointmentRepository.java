package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Appointment;
import org.example.petwell_clinic.entity.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

//@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
      List<Appointment> findAppointmentsByVeterinaryEqualsAndInitTimeAfterAndEndTimeBefore(
            Veterinary veterinary, LocalDateTime  initTime, LocalDateTime endTime);
      List<Appointment> findAppointmentsByVeterinaryIdAndInitTimeAfterAndEndTimeBefore(
              long veterinaryId, LocalDateTime initTime, LocalDateTime stopTime);
//    Boolean existsAppointmentsByVeterinaryIdAndEndTimeBetween (Long veterinaryId, LocalDateTime initTime, LocalDateTime endTime);
//    Boolean existsAppointmentsByVeterinaryIdAndInitTimeBetween(Long veterinaryId, LocalDateTime initTime, LocalDateTime endTime);
//    Boolean existsAppointmentsByVeterinaryIdAndInitTimeBeforeAndEndTimeAfter(Long veterinaryId, LocalDateTime initTime, LocalDateTime endTime);
      Boolean  existsAppointmentsByVeterinaryIdAndInitTimeBeforeAndAndEndTimeAfter(
              long veterinaryId, LocalDateTime initTime, LocalDateTime endTime);
}
