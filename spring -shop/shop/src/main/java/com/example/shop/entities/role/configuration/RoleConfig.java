package com.example.shop.entities.role.configuration;

import com.example.shop.entities.role.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class RoleConfig {

    CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
        return args -> {
        };
    }
}