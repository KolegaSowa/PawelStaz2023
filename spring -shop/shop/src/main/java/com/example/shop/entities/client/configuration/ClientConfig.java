package com.example.shop.entities.client.configuration;

import com.example.shop.entities.client.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class ClientConfig {

    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
        };
    }
}
