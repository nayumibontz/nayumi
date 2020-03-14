package com.sabandal.clinic;

import com.sabandal.clinic.domain.*;
import com.sabandal.clinic.repository.AppointmentRepo;
import com.sabandal.clinic.repository.NotificationRepo;
import com.sabandal.clinic.repository.PatientRepo;
import com.sabandal.clinic.repository.ProcedureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.ArrayList;

@SpringBootApplication
//@ComponentScan(basePackages = {  "domain" ,"repository","controller"})
//@EnableJpaRepositories(basePackages = { "domain","repository" })
//@EntityScan(basePackages = { "domain" ,"repository" })
//public class Data extends SpringBootServletInitializer implements CommandLineRunner {
public class Data {
//    @Autowired
//    AppointmentRepo appointmentRepo;
//
//    @Autowired
//    ProcedureRepo procedureRepo;
//
//    @Autowired
//    PatientRepo patientRepo;
//
//    @Autowired
//    NotificationRepo notificationRepo;

    public static void main(String[] args) {
        SpringApplication.run(Data.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Person person = new Person();
//        person.setFirstname("FirstName");
//        person.setLastname("Lastname");
//        person.setMiddlename("middle name");
//        person.setEmail("email");
//        person.setPassword("password");
//        person.setPersonType("Type a");
//        person.setPhoneNumber("number");
//        person.setUsername("username");
//
//        Patient patient = new Patient();
//        patient.setAddress("PN");
//        patient.setDateOfBirth("birth");
//        patient.setPerson(person);
////        patient =  patientRepo.save(patient);
//
//        ArrayList<Appointment> appointments = new ArrayList<>();
//        Procedure procedure = new Procedure();
//        procedure.setProcedureName("Test name");
//        procedure.setProcedureDetail("Test Detail");
//        procedure.setPrice(10F);
//        Appointment appointment = new Appointment();
//        appointment.setSession("session");
//        appointment.setAppointmentDate("1/25/2020");
//        appointment.setStatus("status");
//        appointment.setProcedure(procedure);
//        appointment.setPatient(patient);
//        appointments.add(appointment);
//        appointments.add(appointment);
//
//      appointmentRepo.saveAll(appointments);
//        ArrayList<Notification> notifications = new ArrayList<Notification>();
//        Notification notif = new Notification();
//        notif.setMessage("Hayst");
//        notif.setNotificationDate("1/26/2020");
//        notif.setPatient(patient);
//        notifications.add(notif);
//        notificationRepo.saveAll(notifications);
//
//    }
}
