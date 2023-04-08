package com.example.data.services;

import com.example.data.domain.MedicalEncounter;
import com.example.data.repositories.MedicalEncounterRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicalEncounterServiceImpl implements MedicalEncounterService {

    private final MedicalEncounterRepository medicalEncounterRepository;

    public MedicalEncounterServiceImpl(MedicalEncounterRepository medicalEncounterRepository) {
        this.medicalEncounterRepository = medicalEncounterRepository;
    }

    @Override
    public MedicalEncounter save(MedicalEncounter medicalEncounter) {
        return medicalEncounterRepository.save(medicalEncounter);
    }
}
