package com.example.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CareProvider {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private String speciality;

    public CareProvider(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }
}
