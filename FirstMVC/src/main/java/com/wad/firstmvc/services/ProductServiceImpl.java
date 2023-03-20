package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    List<Product> products = new ArrayList(List.of(
            new Product(13L, "ice cream", "food", 13),
            new Product(15L, "bike", "sports", 335),
            new Product(19L, "car", "Cars", 5340)));

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product p) {
        products.add(p);
    }
}
