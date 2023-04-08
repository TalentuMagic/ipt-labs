package com.example.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "medicalEncounter")
public class HealthService {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String type;

    @ManyToOne
    private MedicalEncounter medicalEncounter;

    public HealthService(String description, String type) {
        this.description = description;
        this.type = type;
    }
}
