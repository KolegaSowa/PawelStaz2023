package com.example.shop.entities.cart.configuration;

import com.example.shop.entities.cart.repository.CartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class CartConfig {

    CommandLineRunner commandLineRunner(CartRepository cartRepository) {
        return args -> {
        };
    }
}
