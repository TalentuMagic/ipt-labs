package com.example.mvcproducts.domain;

import lombok.Data;

import java.util.HashSet;

import java.util.Set;

@Data
public class Cart {
    private final Set<Product> products = new HashSet<>();
}
