package org.example.petwell_clinic.service;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Appointment;
import org.example.petwell_clinic.entity.Schedule;
import org.example.petwell_clinic.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final ScheduleService scheduleService;

    public void addAppointment(Appointment appointment) {
        if (
                appointmentRepository.existsAppointmentsByVeterinaryIdAndInitTimeBeforeAndAndEndTimeAfter(appointment.getVeterinary().getId(), appointment.getEndTime(), appointment.getInitTime())
//                appointmentRepository.existsAppointmentsByVeterinaryIdAndInitTimeBeforeAndEndTimeAfter(appointment.getVeterinary().getId(), appointment.getInitTime(), appointment.getEndTime()) ||
//                appointmentRepository.existsAppointmentsByVeterinaryIdAndInitTimeBetween(appointment.getVeterinary().getId(), appointment.getInitTime(), appointment.getEndTime()) ||
//                appointmentRepository.existsAppointmentsByVeterinaryIdAndEndTimeBetween(appointment.getVeterinary().getId(), appointment.getInitTime(), appointment.getEndTime())
        )
            throw new RuntimeException("Appointments are intersecting ");
        else
            appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByVeterinaryIdByDay(long veterinaryId, String startTime) {
        LocalDateTime startDateTime, initDay, endDay;
        startDateTime = LocalDateTime.parse(startTime);
        int year = startDateTime.getYear();
        int month = startDateTime.getMonthValue();
        int day = startDateTime.getDayOfMonth();
        initDay = LocalDateTime.of(year, month, day, 0, 0, 0);
        endDay = initDay.plusDays(1);
        List<Appointment> appointments = appointmentRepository.findAppointmentsByVeterinaryIdAndInitTimeAfterAndEndTimeBefore(
                veterinaryId, initDay, endDay);
        appointments.sort(new AppointmentComparator());
        return appointments;
    }

    static class AppointmentComparator implements java.util.Comparator<Appointment> {
        @Override
        public int compare(Appointment a, Appointment b) {
            return a.getInitTime().compareTo(b.getInitTime());
        }
    }


    public List<Appointment> getFreeAppointmentsByVeterinaryByDaY(long veterinaryId, String dataDay) {
        List<Schedule> schedules = new ArrayList<>();
        List<Schedule> daySchedules = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();
        List<Appointment> freeAppointments = new ArrayList<>();
        LocalDateTime dataWork = LocalDateTime.parse(dataDay);
        schedules = scheduleService.getAllSchedulesbyVeterinaryIdbyMonth(veterinaryId, dataWork.getMonthValue());
        daySchedules = schedules.stream().filter(sch -> sch.getStartTime().getDayOfYear() == dataWork.getDayOfYear()).toList();
        appointments = getAppointmentsByVeterinaryIdByDay(veterinaryId, dataDay);
        for (Schedule daySchedule : daySchedules) {
            Appointment appointmentToAdd = new Appointment();
            appointmentToAdd.setInitTime(daySchedule.getStartTime());
            for (Appointment dayAppointment : appointments) {
                appointmentToAdd.setEndTime(dayAppointment.getInitTime());
                freeAppointments.add(appointmentToAdd);
                appointmentToAdd = new Appointment();
                appointmentToAdd.setInitTime(dayAppointment.getEndTime());
            }
            appointmentToAdd.setEndTime(daySchedule.getStopTime());
            freeAppointments.add(appointmentToAdd);
        }
        return freeAppointments;
    }

    public List<Appointment> getAllAppointments() {
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
