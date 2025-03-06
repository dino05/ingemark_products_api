package com.ingemark.products.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;
    private String code;
    private String name;
    private BigDecimal priceEur;
    private BigDecimal priceUsd;
    private boolean isAvailable;
}
