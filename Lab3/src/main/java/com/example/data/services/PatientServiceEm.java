package com.example.data.services;

import com.example.data.domain.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceEm implements PatientService {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Patient save(Patient patient) {
        em.persist(patient);
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        TypedQuery<Patient> query = em.createQuery("select patient from Patient patient", Patient.class);
        return query.getResultList();
    }

    @Override
    public List<Patient> findPatientsByName(String name) {
        TypedQuery<Patient> query = em
                .createQuery("select patient from Patient patient join fetch patient.medicalEncounters " +
                        "where patient.name = :name", Patient.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
