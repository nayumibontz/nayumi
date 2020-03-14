package com.sabandal.clinic.service;

import com.sabandal.clinic.domain.Patient;
import com.sabandal.clinic.dto.PatientInfo;
import com.sabandal.clinic.repository.AppointmentRepo;
import com.sabandal.clinic.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;


    public List<Patient> getAllPatient() {
        return patientRepo.findAll();
    }

    public PatientInfo getPatientById(Long patient_id) {
        Patient patient = patientRepo.getOne(patient_id);
        PatientInfo patientInfo = new PatientInfo();

        patientInfo.setFirstName(patient.getPerson().getFirstname());
        patientInfo.setMiddleName(patient.getPerson().getMiddlename());
        patientInfo.setLastName(patient.getPerson().getLastname());
        patientInfo.setAddress(patient.getAddress());
        patientInfo.setBirthdate(patient.getDateOfBirth());
        patientInfo.setBirthplace(patient.getDateOfBirth());
        patientInfo.setContactNo(patient.getMobileNo());
        patientInfo.setEmail(patient.getPerson().getEmail());
        patientInfo.setGender(patient.getSex());
        patientInfo.setNationality(patient.getNationality());
        patientInfo.setOccupation(patient.getOccupation());
        patientInfo.setReligion(patient.getReligion());
        patientInfo.setTelNo(patient.getTelephoneNo());
        patientInfo.setUsername(patient.getPerson().getUsername());
        patientInfo.setPassword(patient.getPerson().getPassword());
        patientInfo.setPatientId(patient.getPatientId());
        patientInfo.setPersonId((long) patient.getPerson().getPersonID());

        return patientInfo;
    }
}
