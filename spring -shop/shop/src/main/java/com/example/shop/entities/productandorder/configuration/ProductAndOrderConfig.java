package com.example.shop.entities.productandorder.configuration;

import com.example.shop.entities.productandorder.repository.ProductAndOrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProductAndOrderConfig {

    CommandLineRunner commandLineRunner(ProductAndOrderRepository productAndOrderRepository) {
        return args -> {
        };
    }
}
