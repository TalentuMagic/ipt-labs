package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Product;
import com.wad.firstmvc.repositories.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;

// old way of creating products
// @Service
// public class ProductServiceImpl implements ProductService {
// List<Product> products = new ArrayList(List.of(
// new Product(13L, "ice cream", "food", 13),
// new Product(15L, "bike", "sports", 335),
// new Product(19L, "car", "Cars", 5340)));

// @Override
// public List<Product> findAll() {
// return products;
// }

// @Override
// public void save(Product p) {
// products.add(p);
// }
// }

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product findProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product findProductByPrice(int price) {
        return productRepository.findByPrice(price);
    }
}