package com.example.data.bootstrap;

import com.example.data.domain.CareProvider;
import com.example.data.domain.HealthService;
import com.example.data.domain.Patient;
import com.example.data.domain.MedicalEncounter;
import com.example.data.repositories.PatientRepository;
import com.example.data.services.PatientService;
import com.example.data.services.MedicalEncounterService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final MedicalEncounterService medicalEncounterService;
    private final PatientService patientService;

    public DataLoader(MedicalEncounterService medicalEncounterService,
            @Qualifier("patientServiceEm") PatientService patientService,
            PatientRepository patientRepository) {
        this.medicalEncounterService = medicalEncounterService;
        this.patientService = patientService;
    }

    @Override
    public void run(String... args) throws Exception {
        CareProvider careProvider1 = new CareProvider("Keiran John", "Assistant");
        MedicalEncounter medicalEncounter1 = new MedicalEncounter(new Date(2020, 9, 10), careProvider1);
        HealthService healthService1 = new HealthService("Kidney Operation", "Operations");
        HealthService healthService2 = new HealthService("Eye Consultation", "Consultations");
        medicalEncounter1.addHealthService(healthService1);
        medicalEncounter1.addHealthService(healthService2);
        Patient patient = new Patient("Mike Oshea");
        patient.addMedicalEncounter(medicalEncounter1);
        patientService.save(patient);
        List<Patient> patients = patientService.findPatientsByName("Mike Oshea");
        patients.forEach(System.out::println);
    }
}
