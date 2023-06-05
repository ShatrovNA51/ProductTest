package com.example.producttest.service;

import com.example.producttest.entity.Manufacturer;
import com.example.producttest.entity.Product;
import com.example.producttest.repository.ManufacturerRepository;
import com.example.producttest.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository<Product> productRepository;

    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Product> getAll() {
        List<Product> returnList = new ArrayList<>();
        Iterable<Product> iterable = productRepository.findAll();
        for (Product product : iterable) {
            returnList.add(product);
        }
        return returnList;
    }

    @Override
    public List<Product> getAllByType(String type) {
        List<Product> returnList = new ArrayList<>();
        Iterable<Product> iterable = productRepository.findByType(type);
        for (Product product : iterable) {
            returnList.add(product);
        }
        return returnList;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {

        if (product.getManufacturer() != null) {
            Manufacturer manufacturer = manufacturerRepository.findById(product.getManufacturer().getId()).orElse(null);
            if (manufacturer == null) {
                    manufacturer = manufacturerRepository.save(Manufacturer.builder()
                            .name(product.getManufacturer().getName()).build());
            }
            product.setManufacturer(manufacturer);
        }

        return productRepository.save(product);
    }

}
