package com.example.shop.entities.productandcart.configuration;

import com.example.shop.entities.productandcart.repository.ProductAndCartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProductAndCartConfig {

    CommandLineRunner commandLineRunner(ProductAndCartRepository productAndCartRepository) {
        return args -> {
        };
    }
}
