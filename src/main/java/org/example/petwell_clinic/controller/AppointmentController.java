package org.example.petwell_clinic.controller;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Appointment;
import org.example.petwell_clinic.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/add/{petId}/{veterinaryId}/{startTime}/{stopTime}")
    public void addAppointment( @RequestBody Appointment appointment,
            @PathVariable(name="petId") long petId,
            @PathVariable(name="veterinaryId") long veterinaryId ,
            @PathVariable(name="startTime") String startTime,
            @PathVariable(name="stopTime") String stopTime) {
           appointmentService.addAppointment(appointment,petId,veterinaryId, startTime, stopTime);
    }

    @GetMapping("/get/{veterinaryId}/{startTime}")
    public List<Appointment> getAppointmentsByVeterinaryIdByDay(@PathVariable(name="veterinaryId") long veterinaryId,
                                                               @PathVariable(name="startTime") String startTime) {
       return appointmentService.getAppointmentsByVeterinaryIdByDay(veterinaryId,startTime);
    }
}
