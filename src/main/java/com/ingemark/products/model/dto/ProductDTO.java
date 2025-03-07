package com.ingemark.products.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    @NotBlank(message = "Code is required")
    @Size(min = 10, max = 10, message = "Code must be exactly 10 characters")
    private String code;
    private String name;
    @DecimalMin(value = "0.0", inclusive = true, message = "Price EUR must be greater than or equal to 0")
    private BigDecimal priceEur;
    private BigDecimal priceUsd;
    @JsonProperty("isAvailable")
    private boolean isAvailable;
}