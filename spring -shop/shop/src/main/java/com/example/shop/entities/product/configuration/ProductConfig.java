package com.example.shop.entities.product.configuration;

import com.example.shop.entities.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProductConfig {

    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
        };
    }
}
