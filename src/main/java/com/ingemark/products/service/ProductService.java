package com.ingemark.products.service;

import com.ingemark.products.exceptions.*;
import com.ingemark.products.model.dto.ProductDTO;
import com.ingemark.products.model.entity.Product;
import com.ingemark.products.repo.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private ExchangeRateService exchangeRateService;

    public ProductDTO getProductById(Long productId){
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return modelMapper.map(product, ProductDTO.class);
    }

    public Page<ProductDTO> getAllProducts(Pageable pageable){
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.map(product -> modelMapper.map(product, ProductDTO.class));
    }

    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO){

        if(productDTO.getCode().length() != 10){
            throw new InvalidCodeException("Code must be exactly 10 characters!");
        }

        if (productRepository.existsByCode(productDTO.getCode())) {
            throw new DuplicateCodeException("Code must be unique!");
        }

        if (productDTO.getPriceEur().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidPriceException("Price EUR must be greater than or equal to 0!");
        }

        BigDecimal exchangeRate;
        try {
            exchangeRate = exchangeRateService.fetchExchangeRate();
        } catch (Exception e) {
            throw new ExchangeRateFetchException("Failed to fetch exchange rate: " + e.getMessage());
        }

        BigDecimal priceUsd = productDTO.getPriceEur().multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP);
        productDTO.setPriceUsd(priceUsd);

        Product product = modelMapper.map(productDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }
}
