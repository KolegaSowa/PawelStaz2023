package com.example.shop.entities.employeedata.service;

import com.example.shop.dto.EmployeeDataDTO;

import java.util.List;

public interface EmployeeDataService {
    List<EmployeeDataDTO> getEmployeeData();

    void addEmployeeData(String loginEmployee, String passwordEmployee, String emailEmployee);

    void deleteEmployeeData(Long idEmployeeData);

    void updateEmployeeData(Long idEmployeeData, String loginEmployee, String passwordEmployee, String emailEmployee);

    List<EmployeeDataDTO> getAuditEmployeeData(Long idEmployeeData);
}
