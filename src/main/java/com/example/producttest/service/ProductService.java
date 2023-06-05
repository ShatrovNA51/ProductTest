package com.example.producttest.service;

import com.example.producttest.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    List<Product> getAllByType(String type);

    Product getById(Long id);

    Product save(Product product);

}
