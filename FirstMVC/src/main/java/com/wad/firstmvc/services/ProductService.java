package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findProductByName(String name);

    Product findProductByCategory(String category);

    Product findProductByPrice(int price);

    Product saveProduct(Product p);

}
