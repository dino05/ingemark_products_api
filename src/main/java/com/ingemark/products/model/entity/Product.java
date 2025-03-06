package com.ingemark.products.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class Product {
    private Long id;
    private String code;
    private String name;
    private BigDecimal priceEur;
    private BigDecimal priceUsd;
    private boolean isAvailable;
}