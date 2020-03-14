package com.sabandal.clinic.service;

import com.sabandal.clinic.domain.Appointment;
import com.sabandal.clinic.domain.Notification;
import com.sabandal.clinic.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    public Notification getNotificationById(Long id) {
        return notificationRepo.getOne(id);
    }

    public Notification findNotificationById(Long id) {
        return notificationRepo.getOne(id);
    }

    public void deleteNotificationById(Notification notification) {
        notificationRepo.delete(notification);
    }

    public void createNotification(Appointment app) {
        Notification notif = new Notification();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate= formatter.format(date);
        notif.setNotificationDate(strDate);
        notif.setPatient(app.getPatient());
        notif.setMessage("Your appointment request this "+ app.getAppointmentDate() +" has been "+app.getStatus()+"!");
        notificationRepo.save(notif);
    }
}
