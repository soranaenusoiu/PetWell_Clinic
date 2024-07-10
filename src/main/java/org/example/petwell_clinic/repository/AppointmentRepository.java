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
//    Boolean existsAppointmentsByVeterinaryIdAndEndTimeBetween (Long veterinaryId, LocalDateTime initTime, LocalDateTime endTime);
//    Boolean existsAppointmentsByVeterinaryIdAndInitTimeBetween(Long veterinaryId, LocalDateTime initTime, LocalDateTime endTime);
//    Boolean existsAppointmentsByVeterinaryIdAndInitTimeBeforeAndEndTimeAfter(Long veterinaryId, LocalDateTime initTime, LocalDateTime endTime);
    Boolean existsAppointmentByVeterinaryIdAndInitTimeAfterOrVeterinaryIdAndEndTimeBefore(Long veterinary_id, LocalDateTime initTime, Long veterinary_id2, LocalDateTime endTime);


}
