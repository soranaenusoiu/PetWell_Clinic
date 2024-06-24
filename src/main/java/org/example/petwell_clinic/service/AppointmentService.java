package org.example.petwell_clinic.service;

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

    public void addAppointment(Appointment  appointment, long petId, long veterinaryId, String initTime, String endTime){
        Veterinary veterinary=veterinaryRepository.findById(veterinaryId).orElseThrow(NoSuchElementException::new);
        appointment.setVeterinary(veterinary);
        Pet pet=petRepository.findById(petId).orElseThrow(NoSuchElementException::new);
        appointment.setPet(pet);
        appointment.setInitTime(LocalDateTime.parse(initTime));
        appointment.setEndTime(LocalDateTime.parse(endTime));
        appointmentRepository.save(appointment);
    }

    // lista ordonata dupa timpul de start a intervalelor programate
    public List<Appointment> getAppointmentsByVeterinaryIdByDay(long veterinaryId, String startTime){
        List<Appointment> appointments;
        Veterinary veterinary;
        LocalDateTime startDateTime,initDay, endDay;
        startDateTime=LocalDateTime.parse(startTime);
        veterinary=veterinaryRepository.findById(veterinaryId).orElseThrow(NoSuchElementException::new);
        int year=startDateTime.getYear();
        int month=startDateTime.getMonthValue();
        int day=startDateTime.getDayOfMonth();
        initDay=LocalDateTime.of(year,month,day,0,0,0);
        endDay=initDay.plusDays(1);
        appointments= appointmentRepository.findAppointmentByVeterinaryEqualsAndInitTimeAfterAndEndTimeBefore(
                veterinary, initDay,endDay);
        Collections.sort(appointments, new AppointmentComparator());
        return appointments;
    }

    static class AppointmentComparator implements java.util.Comparator<Appointment> {
        @Override
        public int compare(Appointment a, Appointment b) {
            return a.getInitTime().compareTo(b.getInitTime());
        }
    }


}
