package com.example.shop.security;

import com.example.shop.entities.employee.model.EmployeeUserDetails;
import com.example.shop.entities.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> employees = employeeRepository
                .findAll()
                .stream()
                .map(EmployeeUserDetails::new)
                .map(UserDetails.class::cast)
                .toList();

        return new InMemoryUserDetailsManager(employees);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/role/get").hasRole("Seller")
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(formLogin -> formLogin
                        .permitAll()
                        .defaultSuccessUrl("/home", true)
                        .failureForwardUrl("/login")
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}