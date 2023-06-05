package com.example.producttest.repository;

import com.example.producttest.entity.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
}
