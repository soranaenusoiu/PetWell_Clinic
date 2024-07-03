package org.example.petwell_clinic.service;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Schedule;
import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.repository.ScheduleRepository;
import org.example.petwell_clinic.repository.VeterinaryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final VeterinaryRepository veterinaryRepository;

    public void addSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(long id){
        return scheduleRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Schedule> getAllSchedulesbyVeterinaryIdbyMonth(long veterinaryId, int month) {
        // aici se cpnstruiesc parametrii - id, inceput luna x, final luna x
        Veterinary veterinary=veterinaryRepository.findById(veterinaryId).orElseThrow(NoSuchElementException::new);
        LocalDateTime today, initLocalDataTime, endLocalDataTime;
        today= LocalDateTime.now();
        int currentMonth=today.getMonthValue();
        int year=today.getYear();
        if (currentMonth>month) {year++;}
        initLocalDataTime=LocalDateTime.of(year,month,1,0,0,0);
        endLocalDataTime=initLocalDataTime.plusMonths(1);
        return scheduleRepository.findSchedulesByVeterinaryEqualsAndStartTimeAfterAndStopTimeBefore
                (veterinary, initLocalDataTime, endLocalDataTime);
    }

    public String updateScheduleyByObject(Schedule schedule) {
        System.out.println(schedule);
        Schedule scheduleToUpdate = scheduleRepository.findById(schedule.getId())
                .orElseThrow(NoSuchElementException::new);
        scheduleToUpdate.setStartTime(schedule.getStartTime());
        scheduleToUpdate.setStopTime(schedule.getStartTime());
        scheduleRepository.save(schedule);
        return ("schedule updated");
    }

    public void deleteScheduleById(long id) {
        Schedule scheduleToDelete  = scheduleRepository.findById(id).orElseThrow(NoSuchElementException::new);
        scheduleRepository.delete(scheduleToDelete);
    }
}
