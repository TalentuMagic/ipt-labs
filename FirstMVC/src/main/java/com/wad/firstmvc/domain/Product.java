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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private int price;

    // the constructor for the domain
    public Product(String name, String category, int price) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    // setters
    public void setName(String inputName) {
        name = inputName;
    }

    public void setCategory(String inputCategory) {
        category = inputCategory;
    }

    public void setPrice(int inputPrice) {
        price = inputPrice;
    }
}
