package com.sabandal.clinic.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "appointment")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Appointment implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentid")
    private long appointmentId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "procedure_id", nullable = false)
    private Procedure procedure;

    @Column(name = "session")
    private String session;

    @Column(name = "appointmentdate")
    private String appointmentDate;

    @Column(name = "status")
    private String status;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="patient_id", nullable = false)
    private  Patient patient;

//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name="dentist_id", nullable = false)
//    private  Dentist dentist;

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

//    public long getProcedureId() {
//        return procedureId;
//    }
//
//    public void setProcedureId(long procedureId) {
//        this.procedureId = procedureId;
//    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public Procedure getProcedure() {
         return  this.procedure;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "session='" + session + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}