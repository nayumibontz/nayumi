package com.sabandal.clinic.repository;

import com.sabandal.clinic.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {

}
