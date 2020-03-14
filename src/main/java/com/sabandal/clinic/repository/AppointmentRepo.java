package com.sabandal.clinic.repository;

import com.sabandal.clinic.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Appointment findById(long id);
    List<Appointment> findByStatus(String status);
}
