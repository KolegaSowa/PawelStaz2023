package com.example.shop.entities.employeedata.mapper;

import com.example.shop.dto.EmployeeDataDTO;
import com.example.shop.entities.employeedata.model.EmployeeData;
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
public class EmployeeDataMapperImpl implements EmployeeDataMapper {

    @Override
    public EmployeeData dtoToEntity(EmployeeDataDTO employeeDataDTO) {
        if ( employeeDataDTO == null ) {
            return null;
        }

        EmployeeData.EmployeeDataBuilder employeeData = EmployeeData.builder();

        employeeData.idEmployeeData( employeeDataDTO.getIdEmployeeData() );
        employeeData.loginEmployee( employeeDataDTO.getLoginEmployee() );
        employeeData.passwordEmployee( employeeDataDTO.getPasswordEmployee() );
        employeeData.emailEmployee( employeeDataDTO.getEmailEmployee() );

        return employeeData.build();
    }

    @Override
    public List<EmployeeData> dtoToEntity(List<EmployeeDataDTO> employeeDataDTOS) {
        if ( employeeDataDTOS == null ) {
            return null;
        }

        List<EmployeeData> list = new ArrayList<EmployeeData>( employeeDataDTOS.size() );
        for ( EmployeeDataDTO employeeDataDTO : employeeDataDTOS ) {
            list.add( dtoToEntity( employeeDataDTO ) );
        }

        return list;
    }

    @Override
    public EmployeeDataDTO entityToDTO(EmployeeData employeeData) {
        if ( employeeData == null ) {
            return null;
        }

        EmployeeDataDTO employeeDataDTO = new EmployeeDataDTO();

        employeeDataDTO.setIdEmployeeData( employeeData.getIdEmployeeData() );
        employeeDataDTO.setLoginEmployee( employeeData.getLoginEmployee() );
        employeeDataDTO.setPasswordEmployee( employeeData.getPasswordEmployee() );
        employeeDataDTO.setEmailEmployee( employeeData.getEmailEmployee() );

        return employeeDataDTO;
    }

    @Override
    public List<EmployeeDataDTO> entityToDTO(List<EmployeeData> employeeData) {
        if ( employeeData == null ) {
            return null;
        }

        List<EmployeeDataDTO> list = new ArrayList<EmployeeDataDTO>( employeeData.size() );
        for ( EmployeeData employeeData1 : employeeData ) {
            list.add( entityToDTO( employeeData1 ) );
        }

        return list;
    }
}
