package com.example.shop.entities.historyofchange.configuration;

import com.example.shop.entities.historyofchange.repository.HistoryOfChangeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
class HistoryOfChangeConfig {

    CommandLineRunner commandLineRunner(HistoryOfChangeRepository historyOfChangeRepository) {
        return args -> {
        };
    }
}
