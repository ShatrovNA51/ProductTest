package com.example.producttest.entity;


import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
public abstract class Product {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Manufacturer manufacturer;

    @Column(name = "serial_number")
    private String serialNumber;

    private BigDecimal price;

    private Long quantity;

    private String type;

}
