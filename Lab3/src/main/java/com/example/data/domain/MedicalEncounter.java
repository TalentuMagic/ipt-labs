package com.example.data.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "healthServices", "patients" })
@ToString(exclude = "patients")
public class MedicalEncounter {

    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    @OneToOne(cascade = CascadeType.PERSIST)
    private CareProvider careProvider;

    @ManyToMany(mappedBy = "medicalEncounters", cascade = CascadeType.PERSIST)
    private Set<Patient> patients = new HashSet<>();

    @OneToMany(mappedBy = "medicalEncounter", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<HealthService> healthServices = new HashSet<>();

    public MedicalEncounter(Date date, CareProvider careProvider) {
        this.date = date;
        this.careProvider = careProvider;
    }

    public void addHealthService(HealthService healthService) {
        this.getHealthServices().add(healthService);
        healthService.setMedicalEncounter(this);
    }
}