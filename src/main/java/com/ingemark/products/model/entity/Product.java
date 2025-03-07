package com.ingemark.products.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "price_eur")
    private BigDecimal priceEur;
    @Column(name = "price_usd")
    private BigDecimal priceUsd;
    @Column(name = "is_available")
    private boolean isAvailable;
}