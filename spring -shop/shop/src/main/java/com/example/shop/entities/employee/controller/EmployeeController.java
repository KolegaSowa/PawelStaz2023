package com.example.shop.entities.employee.controller;

import com.example.shop.dto.EmployeeDTO;
import com.example.shop.entities.employee.service.EmployeeService;
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
@RequestMapping(path = "/employee")
class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getEmployee() {
        return employeeService.getEmployee();
    }

    @PostMapping
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.addEmployee(employeeDTO);
    }

    @DeleteMapping(path = "{id_employee}")
    public void deleteEmployee(@PathVariable("id_employee") Long idEmployee) {
        employeeService.deleteEmployee(idEmployee);
    }

    @PutMapping("/update/{idEmployee}")
    public void updateEmployee(@PathVariable long idEmployee, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(idEmployee, employeeDTO.getNameEmployee(), employeeDTO.getLastNameEmployee(), employeeDTO.getRole(), employeeDTO.getEmployeeData());
    }

    @GetMapping("/audited/{idEmployee}")
    List<EmployeeDTO> getAuditEmployee(@PathVariable long idEmployee) {
        return employeeService.getAuditEmployee(idEmployee);
    }
}