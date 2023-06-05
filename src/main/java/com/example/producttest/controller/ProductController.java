package com.example.producttest.controller;

import com.example.producttest.dto.ProductDto;
import com.example.producttest.entity.*;
import com.example.producttest.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    private ModelMapper modelMapper;

    private Product toEntity(ProductDto productDto) {
        return switch (productDto.getType()) {
            case "HDD" -> modelMapper.map(productDto, HardDriveProduct.class);
            case "LAPTOP" -> modelMapper.map(productDto, LaptopProduct.class);
            case "MONITOR" -> modelMapper.map(productDto, MonitorProduct.class);
            case "PC" -> modelMapper.map(productDto, PersonalComputerProduct.class);
            default -> null;
        };
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        return ResponseEntity.ok(productService.getAll().stream().map(product -> modelMapper.map(product, ProductDto.class)).toList());
    }

    @GetMapping(value = "/type/{type}")
    public ResponseEntity<List<ProductDto>> getAllByType(@PathVariable String type) {
        return ResponseEntity.ok(productService.getAllByType(type).stream().map(product -> modelMapper.map(product, ProductDto.class)).toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(modelMapper.map(productService.getById(id), ProductDto.class));
    }

    @PostMapping
    public ResponseEntity<ProductDto> add(@RequestBody ProductDto newProduct) {
        return ResponseEntity.ok(modelMapper.map(productService.save(toEntity(newProduct)),ProductDto.class));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDto> edit(@PathVariable Long id, @RequestBody ProductDto editProduct) {
        Product oldProduct = productService.getById(id);
        editProduct.setId(id);
        if (oldProduct != null) {
            Product returnProduct = productService.save(toEntity(editProduct));
            return ResponseEntity.ok().body(modelMapper.map(returnProduct, ProductDto.class));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
