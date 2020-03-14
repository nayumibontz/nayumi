package com.sabandal.clinic.controller;

import com.sabandal.clinic.domain.Appointment;
import com.sabandal.clinic.domain.Notification;
import com.sabandal.clinic.domain.Patient;
import com.sabandal.clinic.dto.PatientAppointment;
import com.sabandal.clinic.repository.PatientRepo;
import com.sabandal.clinic.repository.ProcedureRepo;
import com.sabandal.clinic.service.AppointmentService;
import com.sabandal.clinic.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    NotificationService notificationService;

    @GetMapping("/appointments/{patient_id}")
    public List<PatientAppointment> getAllAppointmentsByPatientId(@PathVariable(value = "patient_id") Long id) {
        return appointmentService.getAllAppointmentByPatientId(id);
    }

//    @PutMapping("/appointment/{id}")
//    public Appointment updateAppointmentById(@PathVariable(value = "id") Long appointment_id, @RequestBody Appointment app) {
//        Appointment appointment = appointmentService.updateAppointment(appointment_id, app);
////        notificationService.createNotification(appointment);
//        return appointment;
//    }

    @PostMapping("/book")
    public boolean createAppointment(@RequestBody Appointment appointment) {
        try{
            appointmentService.createAppointment(appointment);
            return true;
        }catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
    }

    @GetMapping("/notifications/{patient_id}")
    public List<Notification> getAllNotificationsByPatientId(@PathVariable(value = "patient_id") Long id) {
        return appointmentService.getAllNotificationsByPatientId(id);
    }

    @DeleteMapping("/notification/{notificationid}")
    public Notification deleteNotificationById(@PathVariable(value = "notificationid") Long id) {
            Notification notif = notificationService.findNotificationById(id);
            notificationService.deleteNotificationById(notif);
            return notif;
        }
    }