package com.wad.firstmvc.repositories;

import java.util.List;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wad.firstmvc.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    Product findByName(String name);

    Product findByCategory(String category);

    Product findByPrice(int price);
}
