package com.example.shop.audit;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AuditConfig {

    private final EntityManagerFactory entityManagerFactory;

    @Bean
    AuditReader auditReader(){
     return AuditReaderFactory.get(entityManagerFactory.createEntityManager());
    }
}
