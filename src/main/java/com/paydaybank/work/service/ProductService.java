package com.paydaybank.work.service;

import com.paydaybank.work.entity.Product;
import com.paydaybank.work.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public List<Product> updateProduct(Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }
}
