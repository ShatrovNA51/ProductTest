package com.example.producttest.repository;

import com.example.producttest.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProductRepository<T extends Product>
        extends CrudRepository<T, Long> {
}
