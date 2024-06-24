package org.example.petwell_clinic.controller;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Schedule;
import org.example.petwell_clinic.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/add/{veterinaryId}/{startTime}/{stopTime}")
    public void addSchedule(
            @PathVariable(name="veterinaryId") long veterinaryId ,
            @PathVariable(name="startTime") String startTime,
            @PathVariable(name="stopTime") String stopTime) {
        scheduleService.addSchedule(veterinaryId, startTime, stopTime);
    }

//    @PostMapping("/add1/{veterinaryId}")
//    public void addSchedule1(@RequestBody Schedule schedule, @PathVariable(name="veterinaryId") long veterinaryId) {
//        scheduleService.addSchedule1(schedule, veterinaryId);
//    }

    @DeleteMapping("deleteId{scheduleId}")
    public void deleteScheduleById(@PathVariable(name = "scheduleId") long id) {
        scheduleService.deleteScheduleById(id);
    }

    @GetMapping("/getById/{scheduleId}")
    public Schedule getScheduleById(@PathVariable(name="scheduleId") long scheduleId) {
        return scheduleService.getScheduleById(scheduleId);
    }

}