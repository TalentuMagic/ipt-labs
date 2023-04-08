package com.example.data.services;

import com.example.data.domain.Patient;
import com.example.data.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository facultyRepository;

    public PatientServiceImpl(PatientRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Patient save(Patient patient) {
        return facultyRepository.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return (List<Patient>) facultyRepository.findAll();
    }

    @Override
    public List<Patient> findPatientsByName(String name) {
        return facultyRepository.findPatientsByName(name);
    }
}
