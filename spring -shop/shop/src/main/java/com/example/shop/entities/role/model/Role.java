package com.example.shop.entities.role.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Audited
public class Role {
    @Column(name = "id_role")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRole;

    @Column(name = "employee_role")
    private String employeeRole;
}