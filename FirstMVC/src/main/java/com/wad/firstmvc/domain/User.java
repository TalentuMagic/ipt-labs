package com.wad.firstmvc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;

    // the constructor for the domain
    public User(String name, String email, int age) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    // setters
    public void setName(String inputName) {
        name = inputName;
    }

    public void setEmail(String inputEmail) {
        email = inputEmail;
    }

    public void setAge(int inputAge) {
        age = inputAge;
    }
}