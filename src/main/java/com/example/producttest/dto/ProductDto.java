package com.example.producttest.dto;

import com.example.producttest.entity.PersonalComputerFormFactor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {
    private Long id;

    private ManufacturerDto manufacturer;

    private String modelName;

    private BigDecimal price;

    private Long quantity;

    private String type;

    private Long capacity;

    private Integer size;

    private PersonalComputerFormFactor formFactor;

    private Integer diagonal;

}
