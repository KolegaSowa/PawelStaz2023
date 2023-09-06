package com.example.shop.entities.clientdata.configuration;

import com.example.shop.entities.clientdata.repository.ClientDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class ClientDataConfig {

    CommandLineRunner commandLineRunner(ClientDataRepository clientDataRepository) {
        return args -> {
        };
    }
}
