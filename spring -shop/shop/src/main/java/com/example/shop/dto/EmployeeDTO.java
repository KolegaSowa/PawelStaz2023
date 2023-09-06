package com.example.shop.dto;

import com.example.shop.entities.employeedata.model.EmployeeData;
import com.example.shop.entities.role.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {

    private long idEmployee;
    private String nameEmployee;
    private String lastNameEmployee;
    private Role role;
    private EmployeeData employeeData;
}