package com.example.producttest;


import com.example.producttest.entity.HardDriveProduct;
import com.example.producttest.entity.Product;
import com.example.producttest.repository.ProductRepository;
import com.example.producttest.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository<Product> productRepository;

    @Test
    void getAll() {
        HardDriveProduct hardDriveProduct = new HardDriveProduct();
        hardDriveProduct.setCapacity(12L);
        hardDriveProduct.setType("HDD");
        when(productRepository.findAll()).thenReturn(Collections.singletonList(hardDriveProduct));

        List<Product> productList = productService.getAll();

        assertEquals("HDD", productList.get(0).getType());

    }

    @Test
    void getAllEmpty() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        List<Product> productList = productService.getAll();

        assertTrue(productList.isEmpty());
    }

    @Test
    void getAllByType() {
        HardDriveProduct hardDriveProduct = new HardDriveProduct();
        hardDriveProduct.setCapacity(12L);
        hardDriveProduct.setType("HDD");
        HardDriveProduct hardDriveProduct1 = new HardDriveProduct();
        hardDriveProduct.setCapacity(13L);
        hardDriveProduct.setType("HDD");
        ArrayList<Product> arrayList = new ArrayList<>();
        arrayList.add(hardDriveProduct1);
        arrayList.add(hardDriveProduct);

        when(productRepository.findByType("HDD")).thenReturn(arrayList);

        List<Product> productList = productService.getAllByType("HDD");

        assertEquals(2, productList.size());

    }

    @Test
    void add() {
        HardDriveProduct hardDriveProduct = new HardDriveProduct();
        hardDriveProduct.setType("HDD");
        hardDriveProduct.setCapacity(12L);
        when(productRepository.save(hardDriveProduct)).then(invocationOnMock -> {
            HardDriveProduct hardDriveProduct1 = new HardDriveProduct();
            hardDriveProduct1.setType("HDD");
            hardDriveProduct1.setCapacity(12L);
            hardDriveProduct1.setId(1L);
            return hardDriveProduct1;
        });

        Product product = productService.save(hardDriveProduct);
        assertEquals(1, product.getId());

    }

    @Test
    void getById() {
        HardDriveProduct hardDriveProduct = new HardDriveProduct();
        hardDriveProduct.setCapacity(12L);
        hardDriveProduct.setType("HDD");
        hardDriveProduct.setId(1L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(hardDriveProduct));
        when(productRepository.findById(2L)).thenReturn(Optional.empty());
        Product product1 = productService.getById(1L);
        Product product2 = productService.getById(2L);

        assertEquals(hardDriveProduct, product1);
        assertNull(product2);
    }

}
