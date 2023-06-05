package com.example.producttest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Manufacturer {

    @Id
    @GeneratedValue
    private Long id;

}