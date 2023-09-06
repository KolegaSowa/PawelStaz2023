package com.example.shop.entities.orders.configuration;

import com.example.shop.entities.orders.repository.OrdersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class OrdersConfig {

    CommandLineRunner commandLineRunner(OrdersRepository ordersRepository) {
        return args -> {
        };
    }
}
