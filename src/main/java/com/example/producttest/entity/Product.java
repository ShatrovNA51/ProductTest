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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="manufacturer_id")
    private Manufacturer manufacturer;

    @Column(name = "model_name")
    private String modelName;

    private BigDecimal price;

    private Long quantity;

    @Column(insertable=false, updatable=false)
    private String type;

}
