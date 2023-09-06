package com.example.shop.entities.employee.service;

import com.example.shop.dto.EmployeeDTO;
import com.example.shop.entities.employeedata.model.EmployeeData;
import com.example.shop.entities.role.model.Role;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getEmployee();

    void addEmployee(EmployeeDTO employeeDTO);

    void deleteEmployee(Long idEmployee);

    void updateEmployee(Long idEmployee, String nameEmployee, String lastNameEmployee, Role role, EmployeeData employeeData);

    List<EmployeeDTO> getAuditEmployee(Long idEmployee);
}