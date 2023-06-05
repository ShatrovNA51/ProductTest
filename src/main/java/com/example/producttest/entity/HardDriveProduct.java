package com.example.producttest.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@DiscriminatorValue("HDD")
@Entity
public class HardDriveProduct extends Product {

    //Объем жесткого диска в Гб
    private Long capacity;
}
