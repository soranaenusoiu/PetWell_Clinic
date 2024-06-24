package org.example.petwell_clinic.service;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Schedule;
import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public void addSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public void deleteScheduleById(long id) {
        scheduleRepository.deleteScheduleByScheduleIdEquals(id);
    }

    public List<Schedule> getAllSchedulesbyVeterinaryIdbyMonth(long veterinaryId, int month) {
        // aici se cpnstruiesc parametrii - id, inceput luna x, final luna x
        LocalDateTime today, initLocalDataTime, endLocalDataTime;
        today= LocalDateTime.now();
        int currentMonth=today.getMonthValue();
        int year=today.getYear();
        initLocalDataTime=LocalDateTime.of(year,month,1,0,0,0);
        endLocalDataTime=initLocalDataTime.plusMonths(1);
      //  return scheduleRepository.findAllByVeterinariesIdAndStartTimeAfterAndEndTimeBefore
      //          (veterinaryId, initLocalDataTime, endLocalDataTime);
        return null;
    }
}
