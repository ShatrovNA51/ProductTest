package com.example.producttest;

import com.example.producttest.entity.*;
import com.example.producttest.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository<Product> productRepository;



    @Test
    void findByTypeHDD() {
        HardDriveProduct hardDriveProduct = new HardDriveProduct();
        hardDriveProduct.setCapacity(12L);
        hardDriveProduct.setType("HDD");
        productRepository.save(hardDriveProduct);

        List<Product> productList = productRepository.findByType("HDD");

        assertEquals("HDD", productList.get(0).getType());

    }

    @Test
    void findByTypeLAPTOP() {
        LaptopProduct laptopProduct = new LaptopProduct();
        laptopProduct.setSize(12);
        laptopProduct.setType("LAPTOP");
        productRepository.save(laptopProduct);

        List<Product> productList = productRepository.findByType("LAPTOP");

        assertEquals("LAPTOP", productList.get(0).getType());

    }

    @Test
    void findByTypePC() {
        PersonalComputerProduct personalComputerProduct = new PersonalComputerProduct();
        personalComputerProduct.setFormFactor(PersonalComputerFormFactor.DESKTOP);
        personalComputerProduct.setType("PC");
        productRepository.save(personalComputerProduct);

        List<Product> productList = productRepository.findByType("PC");

        assertEquals("PC", productList.get(0).getType());
    }

    @Test
    void findByTypeMonitor() {
        MonitorProduct monitorProduct = new MonitorProduct();
        monitorProduct.setDiagonal(12);
        monitorProduct.setType("MONITOR");
        productRepository.save(monitorProduct);

        List<Product> productList = productRepository.findByType("MONITOR");

        assertEquals("MONITOR", productList.get(0).getType());

    }

}
