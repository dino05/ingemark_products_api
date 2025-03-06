package com.ingemark.products.controller;

import com.ingemark.products.model.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    @GetMapping("/find-by-id/{productId}")
    public ResponseEntity<ProductDTO> findByProductId(@PathVariable Long productId){
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/find-all")
    public ResponseEntity<ProductDTO> findAll(){
        return ResponseEntity.ok().body(null);
    }

    @PostMapping("/update-cart/{userId}")
    public ResponseEntity<Void> addCartItems(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok().body(null);
    }
}
