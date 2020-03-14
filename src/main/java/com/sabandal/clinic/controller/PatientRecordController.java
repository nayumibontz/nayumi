package com.sabandal.clinic.controller;

import com.sabandal.clinic.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("https://localhost:4200")
public class PatientRecordController {
    @Autowired
    PatientRepo patientRepo;








}
