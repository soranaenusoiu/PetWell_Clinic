package org.example.petwell_clinic.controller;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Appointment;
import org.example.petwell_clinic.entity.Schedule;
import org.example.petwell_clinic.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/add")
    public void addAppointment( @RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);
    }

    @GetMapping("/get/{veterinaryId}/{startTime}")
    public List<Appointment> getAppointmentsByVeterinaryIdByDay(@PathVariable(name="veterinaryId") long veterinaryId,
                                                               @PathVariable(name="startTime") String startTime) {
       return appointmentService.getAppointmentsByVeterinaryIdByDay(veterinaryId,startTime);
    }

    @GetMapping("/getfree/{veterinaryId}/{dataDay}")
    public List<Appointment> getFreeAppointmentsByVeterinaryByDaY(@PathVariable(name="veterinaryId") long veterinaryId,
                                                                @PathVariable(name="dataDay") String dataDay) {
        return appointmentService.getFreeAppointmentsByVeterinaryByDaY(veterinaryId, dataDay);
    }


    @GetMapping("/get/all")
    public List<Appointment> getAllAppointment() {
        return appointmentService.getAllAppointments();
    }


    @PutMapping("/update")
    public void updateAppointment(@RequestBody Appointment appointment) {
        appointmentService.updateAppointmentByObject(appointment);
    }

    @DeleteMapping("/deleteById/{appointmentId}")
    public void deleteAppointmentById(@PathVariable(name = "appointmentId") long id) {
        appointmentService.deleteAppointmentById(id);
    }


}
