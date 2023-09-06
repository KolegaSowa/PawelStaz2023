package com.example.shop.entities.employeedata.mapper;


import com.example.shop.dto.EmployeeDataDTO;
import com.example.shop.entities.employeedata.model.EmployeeData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeDataMapper {

    EmployeeData dtoToEntity(EmployeeDataDTO employeeDataDTO);

    List<EmployeeData> dtoToEntity(List<EmployeeDataDTO> employeeDataDTOS);

    EmployeeDataDTO entityToDTO(EmployeeData employeeData);

    List<EmployeeDataDTO> entityToDTO(List<EmployeeData> employeeData);
}
