package com.example.data.services;

import com.example.data.domain.Patient;

import java.util.List;

public interface PatientService {
    Patient save(Patient patient);

    List<Patient> findAll();

    List<Patient> findPatientsByName(String name);
}