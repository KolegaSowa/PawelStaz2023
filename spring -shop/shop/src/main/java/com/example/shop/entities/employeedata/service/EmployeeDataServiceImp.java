package com.example.shop.entities.employeedata.service;

import com.example.shop.dto.EmployeeDataDTO;
import com.example.shop.entities.employeedata.mapper.EmployeeDataMapper;
import com.example.shop.entities.employeedata.model.EmployeeData;
import com.example.shop.entities.employeedata.repository.EmployeeDataRepository;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
class EmployeeDataServiceImp implements EmployeeDataService {

    private final EmployeeDataRepository employeeDataRepository;
    private final AuditReader auditReader;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeDataMapper employeeDataMapper;

    @Override
    public List<EmployeeDataDTO> getEmployeeData() {
        return employeeDataMapper.entityToDTO(employeeDataRepository.findAll());
    }

    @Override
    public void addEmployeeData(String loginEmployee, String passwordEmployee, String emailEmployee) {
        EmployeeDataDTO employeeDataDTO = new EmployeeDataDTO();
        employeeDataDTO.setLoginEmployee(loginEmployee);
        employeeDataDTO.setPasswordEmployee(passwordEncoder.encode(passwordEmployee));
        employeeDataDTO.setEmailEmployee(emailEmployee);
        employeeDataRepository.save(employeeDataMapper.dtoToEntity(employeeDataDTO));

    }

    @Override
    public void deleteEmployeeData(Long idEmployeeData) {
        boolean exist = employeeDataRepository.existsById(idEmployeeData);
        if (!exist) {
            throw new IllegalStateException(
                    "EmployeeData with id " + idEmployeeData + " does not exist");
        }
        employeeDataRepository.deleteById(idEmployeeData);
    }

    @Override
    public void updateEmployeeData(Long idEmployeeData, String loginEmployee, String passwordEmployee, String emailEmployee) {
        if (employeeDataRepository.findById(idEmployeeData).isPresent()) {
            EmployeeDataDTO employeeDataDTO = employeeDataMapper.entityToDTO(employeeDataRepository.findById(idEmployeeData).get());
            employeeDataDTO.setLoginEmployee(loginEmployee);
            employeeDataDTO.setPasswordEmployee(passwordEncoder.encode(passwordEmployee));
            employeeDataDTO.setEmailEmployee(emailEmployee);
            employeeDataRepository.save(employeeDataMapper.dtoToEntity(employeeDataDTO));
        } else {
            System.out.println("EmployeeData with id " + idEmployeeData + " does not exist");
        }
    }

    @Override
    public List<EmployeeDataDTO> getAuditEmployeeData(Long idEmployeeData) {
        return auditReader.createQuery().forRevisionsOfEntity(EmployeeData.class, true, true).getResultList();
    }
}
