package com.example.data.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "medicalEncounters")
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "patient.medicalEncounter", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "medicalEncounter_id"))
    private Set<MedicalEncounter> medicalEncounters = new HashSet<>();

    public Patient(String name) {
        this.name = name;
    }

    public void addMedicalEncounter(MedicalEncounter medicalEncounter) {
        // Set<MedicalEncounter> medicalEncounter;
        medicalEncounters.add(medicalEncounter);
        medicalEncounter.getPatients().add(this);
    }
}
