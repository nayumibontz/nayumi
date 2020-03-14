package com.sabandal.clinic.controller;

import com.sabandal.clinic.domain.Notification;
import com.sabandal.clinic.domain.Patient;
import com.sabandal.clinic.repository.NotificationRepo;
import com.sabandal.clinic.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//import service.AppointmentService;

@RestController
@CrossOrigin("https://localhost:4200")
public class NotificationController {
    @Autowired
    NotificationRepo notificationRepo;

    @Autowired
    PatientRepo patientRepo;

    @GetMapping("/notifications")
    public List<Notification> getAllNotificationsByPatientId(@RequestParam("patient_id") Long id) {
        List<Notification> notif = new ArrayList<Notification>();

        Patient patient = new Patient();
        patient = patientRepo.getOne(id);

        for (Notification n : patient.getNotifications()) {
            Notification notification = new Notification();
            notification.setNotificationId(n.getNotificationId());
            notification.setNotificationDate(n.getNotificationDate());
            notification.setMessage(n.getMessage());
            notif.add(notification);
        }

        return notif;
    }
}