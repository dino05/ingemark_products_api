package com.ingemark.products.controller;

import com.ingemark.products.model.dto.ProductDTO;
import com.ingemark.products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    @GetMapping("/find-by-id/{productId}")
    public ResponseEntity<ProductDTO> findByProductId(@PathVariable Long productId){
        ProductDTO productDTO = productService.getProductById(productId);
        return ResponseEntity.ok().body(productDTO);
    }

    @GetMapping("/find-all")
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable){
        Page<ProductDTO> products = productService.getAllProducts(pageable);
        return ResponseEntity.ok().body(products);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
}
