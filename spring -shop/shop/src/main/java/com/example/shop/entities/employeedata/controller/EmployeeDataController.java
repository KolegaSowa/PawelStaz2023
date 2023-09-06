package com.example.shop.entities.employeedata.controller;

import com.example.shop.dto.EmployeeDataDTO;
import com.example.shop.entities.employeedata.service.EmployeeDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/employeeData")
class EmployeeDataController {

    private final EmployeeDataService employeeDataService;

    @GetMapping
    public List<EmployeeDataDTO> getEmployeeData() {
        return employeeDataService.getEmployeeData();
    }

    @PostMapping
    public void addEmployeeData(@RequestBody EmployeeDataDTO employeeDataDTO) {
        employeeDataService.addEmployeeData(employeeDataDTO.getLoginEmployee(),employeeDataDTO.getPasswordEmployee(), employeeDataDTO.getEmailEmployee());
    }

    @DeleteMapping(path = "{id_employee_data}")
    public void deleteEmployeeData(@PathVariable("id_employee_data") Long idEmployeeData) {
        employeeDataService.deleteEmployeeData(idEmployeeData);
    }

    @PutMapping("/update/{idEmployeeData}")
    public void updateEmployeeData(@PathVariable long idEmployeeData, @RequestBody EmployeeDataDTO employeeDataDTO) {
        employeeDataService.updateEmployeeData(idEmployeeData, employeeDataDTO.getLoginEmployee(), employeeDataDTO.getPasswordEmployee(), employeeDataDTO.getEmailEmployee());
    }

    @GetMapping("/audited/{idEmployeeData}")
    List<EmployeeDataDTO> getAuditEmployeeData(@PathVariable long idEmployeeData) {
        return employeeDataService.getAuditEmployeeData(idEmployeeData);
    }
}