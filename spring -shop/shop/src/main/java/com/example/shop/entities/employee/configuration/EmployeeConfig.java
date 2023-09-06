package com.example.shop.entities.employee.configuration;

import com.example.shop.entities.employee.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class EmployeeConfig {

    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
        };
    }
}
