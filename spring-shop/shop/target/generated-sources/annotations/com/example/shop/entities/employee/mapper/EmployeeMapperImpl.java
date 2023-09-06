package com.example.shop.entities.employee.mapper;

import com.example.shop.dto.EmployeeDTO;
import com.example.shop.entities.employee.model.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T10:50:20+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee dtoToEntity(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.idEmployee( employeeDTO.getIdEmployee() );
        employee.nameEmployee( employeeDTO.getNameEmployee() );
        employee.lastNameEmployee( employeeDTO.getLastNameEmployee() );
        employee.role( employeeDTO.getRole() );
        employee.employeeData( employeeDTO.getEmployeeData() );

        return employee.build();
    }

    @Override
    public List<Employee> dtoToEntity(List<EmployeeDTO> employeeDTOS) {
        if ( employeeDTOS == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( employeeDTOS.size() );
        for ( EmployeeDTO employeeDTO : employeeDTOS ) {
            list.add( dtoToEntity( employeeDTO ) );
        }

        return list;
    }

    @Override
    public EmployeeDTO entityToDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setIdEmployee( employee.getIdEmployee() );
        employeeDTO.setNameEmployee( employee.getNameEmployee() );
        employeeDTO.setLastNameEmployee( employee.getLastNameEmployee() );
        employeeDTO.setRole( employee.getRole() );
        employeeDTO.setEmployeeData( employee.getEmployeeData() );

        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> entityToDTO(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( entityToDTO( employee ) );
        }

        return list;
    }
}
