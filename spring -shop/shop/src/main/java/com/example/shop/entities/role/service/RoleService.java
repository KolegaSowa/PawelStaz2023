package com.example.shop.entities.role.service;

import com.example.shop.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getRole();

    void addRole(RoleDTO roleDTO);

    void deleteRole(Long idRole);

    void updateRole(Long idRole, String employeeRole);

    List<RoleDTO> getAuditRole(Long idRole);
}