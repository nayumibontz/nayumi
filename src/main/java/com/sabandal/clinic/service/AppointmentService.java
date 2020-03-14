package com.sabandal.clinic.service;

import com.sabandal.clinic.domain.Appointment;
import com.sabandal.clinic.domain.Notification;
import com.sabandal.clinic.domain.Patient;
import com.sabandal.clinic.dto.PatientAppointment;
import com.sabandal.clinic.repository.AppointmentRepo;
import com.sabandal.clinic.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private PatientRepo patientRepo;

    public List<PatientAppointment> getAllAppointmentByPatientId(Long id) {

        List<PatientAppointment> patientAppointments = new ArrayList<PatientAppointment>();

        Patient patient = new Patient();
        patient = patientRepo.getOne(id);

        for (Appointment a : patient.getAppointments()) {
            PatientAppointment patientAppointment = new PatientAppointment();
            patientAppointment.setAppointmentDate(a.getAppointmentDate());
            patientAppointment.setProcedureName(a.getProcedure().getProcedureName());
            patientAppointment.setStatus(a.getStatus());
            patientAppointments.add(patientAppointment);
        }

        return patientAppointments;
    }
//not functional yet!!!
    public void createAppointment(Appointment appointment) {

        //set status to New
        appointment.setStatus("New");
        appointment.setPatient(appointment.getPatient());
        appointment.setProcedure(appointment.getProcedure());
        appointmentRepo.save(appointment);
    }

    public List<Notification> getAllNotificationsByPatientId(Long id) {
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

    public List<PatientAppointment> getAllAppointments(String request) {
        List<PatientAppointment> requestAppointments = new ArrayList<PatientAppointment>();

//        for (Appointment a : appointmentRepo.findByStatus(request)) {
//            PatientAppointment patientAppointment = new PatientAppointment();
//            patientAppointment.setAppointmentId(a.getAppointmentId());
//            patientAppointment.setAppointmentDate(a.getAppointmentDate());
//            patientAppointment.setProcedureName(a.getProcedure().getProcedureName());
//            patientAppointment.setFirstname(a.getPatient().getPerson().getFirstname());
//            patientAppointment.setLastname(a.getPatient().getPerson().getLastname());
//            requestAppointments.add(patientAppointment);
//        }
        return requestAppointments;
    }

    public List<PatientAppointment> getAllAppointmentsByStatus(String  status){
        List<Appointment> appointments = appointmentRepo.findAll();
        List<Appointment> statusAppointments = new ArrayList<>();
        List<PatientAppointment> patientAppointments = new ArrayList<>();


        for (Appointment a: appointments) {
            if (a.getStatus().equals(status)){
                patientAppointments.add(new PatientAppointment(a.getAppointmentId(), a.getProcedure().getProcedureName(), a.getAppointmentDate(), a.getStatus(), a.getPatient().getPerson().getFirstname(), a.getPatient().getPerson().getLastname(), a.getSession()));
            }
        }

        return patientAppointments;
    }

    public PatientAppointment getAppointmentById(Long appointment_id) {
        Appointment appointment = appointmentRepo.getOne(appointment_id);
        System.out.println("appointment: "+appointment.toString());

        PatientAppointment patientAppointment = new PatientAppointment();

        patientAppointment.setAppointmentId(appointment.getAppointmentId());
        patientAppointment.setAppointmentDate(appointment.getAppointmentDate());
        patientAppointment.setProcedureName(appointment.getProcedure().getProcedureName());
        patientAppointment.setFirstname(appointment.getPatient().getPerson().getFirstname() + " " + appointment.getPatient().getPerson().getLastname());
        patientAppointment.setSession(appointment.getSession());

        return patientAppointment;
    }

    public Appointment getOneAppointmentObject(long id){
       return  appointmentRepo.findById(id);
    }

    public void deleteAppointmentById(Long id) {
        appointmentRepo.deleteById(id);
    }

    public Appointment updateAppointment(Long appointment_id) {
        Appointment appointment = this.getOneAppointmentObject(appointment_id);
        appointment.setAppointmentId(appointment.getAppointmentId());
        appointment.setPatient(appointment.getPatient());
        appointment.setStatus("Approved");
        appointment.setAppointmentDate(appointment.getAppointmentDate());
        appointment.setSession(appointment.getSession());
        appointment.setProcedure(appointment.getProcedure());

        appointmentRepo.save(appointment);

        return appointment;

    }


}
