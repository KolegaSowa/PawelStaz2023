package com.example.shop.entities.employeedata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Audited
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee_data")
    private long idEmployeeData;

    @Column(name = "login")
    private String loginEmployee;

    @Column(name = "password")
    private String passwordEmployee;

    @Column(name = "email")
    private String emailEmployee;
}