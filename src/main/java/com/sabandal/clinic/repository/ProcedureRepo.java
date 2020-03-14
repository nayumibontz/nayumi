package com.sabandal.clinic.repository;

import com.sabandal.clinic.domain.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepo extends JpaRepository<Procedure, Long> {

}
