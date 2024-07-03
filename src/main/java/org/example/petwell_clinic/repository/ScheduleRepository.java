package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Schedule;
import org.example.petwell_clinic.entity.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
   // Schedule deleteScheduleByScheduleIdEquals(Long scheduleId);
    List<Schedule> findSchedulesByVeterinaryEqualsAndStartTimeAfterAndStopTimeBefore
          (Veterinary veterinary, LocalDateTime startTime, LocalDateTime endTime);

}
