package com.example.producttest.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("PC")
@Data
@Entity
public class PersonalComputerProduct extends Product {

    PersonalComputerFormFactor formFactor;

}
