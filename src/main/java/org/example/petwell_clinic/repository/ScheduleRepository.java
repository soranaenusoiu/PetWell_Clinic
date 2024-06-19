package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
