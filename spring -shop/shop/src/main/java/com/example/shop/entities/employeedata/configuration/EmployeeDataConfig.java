package com.example.shop.entities.employeedata.configuration;

import com.example.shop.entities.employeedata.repository.EmployeeDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class EmployeeDataConfig {

    CommandLineRunner commandLineRunner(EmployeeDataRepository employeeDataRepository) {
        return args -> {
        };
    }
}
