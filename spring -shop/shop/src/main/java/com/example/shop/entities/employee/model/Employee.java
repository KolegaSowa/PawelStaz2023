package com.example.shop.entities.employee.model;

import com.example.shop.entities.employeedata.model.EmployeeData;
import com.example.shop.entities.role.model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class Employee {

    @Column(name = "id_employee")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmployee;

    @Column(name = "name")
    private String nameEmployee;

    @Column(name = "last_name")
    private String lastNameEmployee;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @OneToOne
    @JoinColumn(name = "id_employee_data")
    private EmployeeData employeeData;
}