package com.example.data.repositories;

import com.example.data.domain.MedicalEncounter;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface MedicalEncounterRepository extends CrudRepository<MedicalEncounter, Long> {
    List<MedicalEncounter> findAll(); // overrides findAll to return a List

    List<MedicalEncounter> findByDate(Date date);

    List<MedicalEncounter> findByHealthServicesEmpty();
}
