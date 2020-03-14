package com.sabandal.clinic.controller;

import com.sabandal.clinic.domain.Appointment;
import com.sabandal.clinic.domain.Notification;
import com.sabandal.clinic.domain.Patient;
import com.sabandal.clinic.dto.PatientAppointment;
import com.sabandal.clinic.dto.PatientInfo;
import com.sabandal.clinic.service.AppointmentService;
import com.sabandal.clinic.service.NotificationService;
import com.sabandal.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DentistController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    PatientService patientService;

    @Autowired
    NotificationService notificationService;


    @GetMapping("/appointments/{status}")
    public List<PatientAppointment> getAllRequestAppointments(@PathVariable String status ) {
            return appointmentService.getAllAppointmentsByStatus(status);
        }

    @GetMapping("/appointment/{appointmentid}")
    public PatientAppointment getAppointmentById(@PathVariable("appointmentid") Long appointment_id) {
            return appointmentService.getAppointmentById(appointment_id);
    }
//for appointment object testing. Will be used in post and update
    @GetMapping("/one/{appointmentid}")
    public Appointment getAllAppointments(@PathVariable(value = "appointmentid") Long appointment_id) {

        Appointment app = appointmentService.getOneAppointmentObject(appointment_id);
        app.toString();
        return app;
    }

    @PutMapping("/appointment/{id}")
    public Appointment updateAppointmentById(@PathVariable(value = "id") Long appointment_id, @RequestBody Appointment app) {
        Appointment appointment = appointmentService.updateAppointment(appointment_id);
        notificationService.createNotification(appointment);
        return appointment;
    }

    @DeleteMapping("/appointment/{appointmentid}")
    public PatientAppointment deleteAppointmentById(@PathVariable("appointmentid") Long appointment_id) {
            PatientAppointment app = appointmentService.getAppointmentById(appointment_id);
            appointmentService.deleteAppointmentById(appointment_id);
            return app;
    }

    @PostMapping("/create")
    public boolean createAppointment(@RequestBody Appointment appointment) {
        try{
            appointmentService.createAppointment(appointment);
            return true;
        }catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
    }

//    @GetMapping("/patient")
//    public List<Patient> getAllPatient() {
//        List<Patient> patient = patientService.getAllPatient();
//        PatientInfo allPatient 0
//
//        return patient;
//    }

    @GetMapping("/patient/{patientid}")
    public PatientInfo getPatientById(@PathVariable("patientid") Long patient_id) {
        PatientInfo patient = patientService.getPatientById(patient_id);
        return patient;
    }










}
