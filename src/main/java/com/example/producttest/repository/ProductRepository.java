package com.example.producttest.repository;

import com.example.producttest.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository<T extends Product>
        extends CrudRepository<T, Long> {
    List<T> findByType(String type);

}
