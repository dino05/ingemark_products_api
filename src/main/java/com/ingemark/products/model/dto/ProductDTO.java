package com.ingemark.products.model.dto;

import java.math.BigDecimal;

public record ProductDTO (
        Long id,
        String code,
        String name,
        BigDecimal priceEur,
        BigDecimal priceUsd,
        boolean isAvailable){}
