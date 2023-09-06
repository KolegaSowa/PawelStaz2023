package com.example.shop.entities.role.mapper;

import com.example.shop.dto.RoleDTO;
import com.example.shop.entities.role.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role dtoToEntity(RoleDTO roleDTO);

    List<Role> dtoToEntity(List<RoleDTO> roleDTOS);

    RoleDTO entityToDTO(Role role);

    List<RoleDTO> entityToDTO(List<Role> roles);
}