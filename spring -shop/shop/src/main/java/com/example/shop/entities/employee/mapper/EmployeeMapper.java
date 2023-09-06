package com.example.shop.entities.employee.mapper;

import com.example.shop.dto.EmployeeDTO;
import com.example.shop.entities.employee.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee dtoToEntity(EmployeeDTO employeeDTO);

    List<Employee> dtoToEntity(List<EmployeeDTO> employeeDTOS);

    EmployeeDTO entityToDTO(Employee employee);

    List<EmployeeDTO> entityToDTO(List<Employee> employees);
}