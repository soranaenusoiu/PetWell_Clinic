package org.example.petwell_clinic.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Appointment;
import org.example.petwell_clinic.entity.Pet;
import org.example.petwell_clinic.entity.Schedule;
import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.repository.AppointmentRepository;
import org.example.petwell_clinic.repository.PetRepository;
import org.example.petwell_clinic.repository.VeterinaryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final VeterinaryRepository veterinaryRepository;
    private final PetRepository petRepository;


    public void addAppointment(Appointment appointment) {
        if (
                appointmentRepository.existsAppointmentByVeterinaryIdAndInitTimeAfterOrVeterinaryIdAndEndTimeBefore(
                        appointment.getVeterinary().getId(), appointment.getEndTime(),appointment.getVeterinary().getId(), appointment.getInitTime())
//                appointmentRepository.existsAppointmentsByVeterinaryIdAndInitTimeBeforeAndEndTimeAfter(appointment.getVeterinary().getId(), appointment.getInitTime(), appointment.getEndTime()) ||
//                appointmentRepository.existsAppointmentsByVeterinaryIdAndInitTimeBetween(appointment.getVeterinary().getId(), appointment.getInitTime(), appointment.getEndTime()) ||
//                appointmentRepository.existsAppointmentsByVeterinaryIdAndEndTimeBetween(appointment.getVeterinary().getId(), appointment.getInitTime(), appointment.getEndTime())
        )
            throw new RuntimeException("Appointments are intersecting ");
        else
            appointmentRepository.save(appointment);

    }

    // lista ordonata dupa timpul de start a intervalelor programate
    public List<Appointment> getAppointmentsByVeterinaryIdByDay(long veterinaryId, String startTime) {
        List<Appointment> appointments;
        Veterinary veterinary;
        LocalDateTime startDateTime, initDay, endDay;
        startDateTime = LocalDateTime.parse(startTime);
        veterinary = veterinaryRepository.findById(veterinaryId).orElseThrow(NoSuchElementException::new);
        int year = startDateTime.getYear();
        int month = startDateTime.getMonthValue();
        int day = startDateTime.getDayOfMonth();
        initDay = LocalDateTime.of(year, month, day, 0, 0, 0);
        endDay = initDay.plusDays(1);
        appointments = appointmentRepository.findAppointmentByVeterinaryEqualsAndInitTimeAfterAndEndTimeBefore(
                veterinary, initDay, endDay);
        Collections.sort(appointments, new AppointmentComparator());
        return appointments;
    }

    static class AppointmentComparator implements java.util.Comparator<Appointment> {
        @Override
        public int compare(Appointment a, Appointment b) {
            return a.getInitTime().compareTo(b.getInitTime());
        }
    }

    public List<Appointment> getAllApointments() {
        List<Appointment> appointments;
        appointments = appointmentRepository.findAll();
        return appointmentRepository.findAll();
    }


    public void updateAppointmentByObject(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void deleteAppointmentById(long id) {
        Appointment appointmentToDelete = appointmentRepository.findById(id).orElseThrow(NoSuchElementException::new);
        appointmentRepository.delete(appointmentToDelete);
    }


}
