package com.example.shop.entities.role.mapper;

import com.example.shop.dto.RoleDTO;
import com.example.shop.entities.role.model.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T11:22:18+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role dtoToEntity(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.idRole( roleDTO.getIdRole() );
        role.employeeRole( roleDTO.getEmployeeRole() );

        return role.build();
    }

    @Override
    public List<Role> dtoToEntity(List<RoleDTO> roleDTOS) {
        if ( roleDTOS == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( roleDTOS.size() );
        for ( RoleDTO roleDTO : roleDTOS ) {
            list.add( dtoToEntity( roleDTO ) );
        }

        return list;
    }

    @Override
    public RoleDTO entityToDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setIdRole( role.getIdRole() );
        roleDTO.setEmployeeRole( role.getEmployeeRole() );

        return roleDTO;
    }

    @Override
    public List<RoleDTO> entityToDTO(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( roles.size() );
        for ( Role role : roles ) {
            list.add( entityToDTO( role ) );
        }

        return list;
    }
}
