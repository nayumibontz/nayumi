package com.sabandal.clinic.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dentist")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Dentist implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dentist_id")
    private long dentistId;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="person_id", nullable = false)
    private  Person person;

    @Column(name = "licenseno")
    private String licenseNo;

    @Column(name = "yearsofexpertise")
    private String yearsOfExpertise;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getDentistId() {
        return dentistId;
    }

    public void setDentistId(long dentistId) {
        this.dentistId = dentistId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getYearsOfExpertise() {
        return yearsOfExpertise;
    }

    public void setYearsOfExpertise(String yearsOfExpertise) {
        this.yearsOfExpertise = yearsOfExpertise;
    }
}
