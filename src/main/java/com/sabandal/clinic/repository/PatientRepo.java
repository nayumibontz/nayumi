package com.sabandal.clinic.repository;

import com.sabandal.clinic.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
