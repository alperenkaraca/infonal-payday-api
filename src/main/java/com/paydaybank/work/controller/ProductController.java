package com.paydaybank.work.controller;

import com.paydaybank.work.entity.Product;
import com.paydaybank.work.service.ProductService;
import com.paydaybank.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController( ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findProducts());
    }

    @PostMapping("/products")
    public ResponseEntity<List<Product>> updateProducts(@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }
}
