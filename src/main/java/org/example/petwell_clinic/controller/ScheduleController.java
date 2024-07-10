package org.example.petwell_clinic.controller;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Appointment;
import org.example.petwell_clinic.entity.Schedule;
import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/add")
    public void addSchedule(@RequestBody Schedule schedule) {
        scheduleService.addSchedule(schedule);
    }

    @GetMapping("/getAll")
    public List<Schedule> getAllSchedule() {
        return scheduleService.getAllSchedule();
    }

    @GetMapping("/getById/{scheduleId}")
    public Schedule getScheduleById(@PathVariable(name="scheduleId") long scheduleId) {
        return scheduleService.getScheduleById(scheduleId);
    }

    @GetMapping("/getByVetByMonth/{veterinaryId}/{month}")
    public List<Schedule> getSchedulebyVetByMonth(@PathVariable(name="veterinaryId") long veterinaryId,
                                                  @PathVariable(name="month") int month) {
        return scheduleService.getAllSchedulesbyVeterinaryIdbyMonth(veterinaryId, month);
    }


    @PutMapping("/update")
    public void updateAppointment(@RequestBody Schedule schedule) {
        scheduleService.updateScheduleByObject(schedule);
    }


    @DeleteMapping("/deleteById/{scheduleId}")
    public void deleteScheduleById(@PathVariable(name = "scheduleId") long id) {
        scheduleService.deleteScheduleById(id);
    }
}