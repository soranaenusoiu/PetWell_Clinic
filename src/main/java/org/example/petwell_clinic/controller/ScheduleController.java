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

    @PostMapping("/add")
    public void addSchedule(@RequestBody Schedule schedule) {
        scheduleService.addSchedule(schedule);
    }

    @DeleteMapping("deleteId{scheduleId}")
    public void deleteScheduleById(@PathVariable(name = "scheduleId") long id) {
        scheduleService.deleteScheduleById(id);
    }


}