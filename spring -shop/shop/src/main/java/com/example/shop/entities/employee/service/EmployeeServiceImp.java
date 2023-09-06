package com.example.shop.entities.employee.service;

import com.example.shop.dto.EmployeeDTO;
import com.example.shop.entities.employee.mapper.EmployeeMapper;
import com.example.shop.entities.employee.model.Employee;
import com.example.shop.entities.employee.repository.EmployeeRepository;
import com.example.shop.entities.employeedata.model.EmployeeData;
import com.example.shop.entities.role.model.Role;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AuditReader auditReader;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> getEmployee() {
        return employeeMapper.entityToDTO(employeeRepository.findAll());
    }

    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(employeeMapper.dtoToEntity(employeeDTO));
    }

    @Override
    public void deleteEmployee(Long idEmployee) {
        boolean exist = employeeRepository.existsById(idEmployee);
        if (!exist) {
            throw new IllegalStateException(
                    "Employee with id " + idEmployee + " does not exist");
        }
        employeeRepository.deleteById(idEmployee);
    }

    @Override
    public void updateEmployee(Long idEmployee, String nameEmployee, String lastNameEmployee, Role role, EmployeeData employeeData) {
        if (employeeRepository.findById(idEmployee).isPresent()) {
            EmployeeDTO employeeDTO = employeeMapper.entityToDTO(employeeRepository.findById(idEmployee).get());
            employeeDTO.setNameEmployee(nameEmployee);
            employeeDTO.setLastNameEmployee(lastNameEmployee);
            employeeDTO.setRole(role);
            employeeDTO.setEmployeeData(employeeData);
            employeeRepository.save(employeeMapper.dtoToEntity(employeeDTO));
        } else {
            System.out.println("Employee with id " + idEmployee + " does not exist");
        }
    }

    @Override
    public List<EmployeeDTO> getAuditEmployee(Long idEmployee) {
        return auditReader.createQuery().forRevisionsOfEntity(Employee.class, true, true).getResultList();
    }
}