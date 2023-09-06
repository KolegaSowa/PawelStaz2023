package com.example.shop.entities.address.configuration;

import com.example.shop.entities.address.repository.AddressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class AddressConfig {

    CommandLineRunner commandLineRunner(AddressRepository addressRepository) {
        return args -> {};
    }
}
