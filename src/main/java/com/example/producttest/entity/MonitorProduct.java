package com.example.producttest.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("MONITOR")
@Data
@Entity
public class MonitorProduct extends Product {
    private Integer diagonal;
}
