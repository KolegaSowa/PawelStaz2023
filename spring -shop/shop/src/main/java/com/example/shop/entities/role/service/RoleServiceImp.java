package com.example.shop.entities.role.service;

import com.example.shop.dto.RoleDTO;
import com.example.shop.entities.role.mapper.RoleMapper;
import com.example.shop.entities.role.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;
    private final AuditReader auditReader;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleDTO> getRole() {
        return roleMapper.entityToDTO(roleRepository.findAll());
    }

    @Override
    public void addRole(RoleDTO roleDTO) {
        roleRepository.save(roleMapper.dtoToEntity(roleDTO));
    }

    @Override
    public void deleteRole(Long idRole) {
        boolean exist = roleRepository.existsById(idRole);
        if (!exist) {
            throw new IllegalStateException(
                    "Role with id" + idRole + "does not exist");
        }
        roleRepository.deleteById(idRole);
    }

    @Override
    public void updateRole(Long idRole, String employeeRole) {
        if (roleRepository.findById(idRole).isPresent()) {
            RoleDTO role = roleMapper.entityToDTO(roleRepository.findById(idRole).get());
            role.setEmployeeRole(employeeRole);
            roleRepository.save(roleMapper.dtoToEntity(role));
        } else {
            System.out.println("Role with id" + idRole + "does not exist");
        }
    }

    @Override
    public List<RoleDTO> getAuditRole(Long idRole) {
        return auditReader.createQuery().forRevisionsOfEntity(RoleDTO.class, true, true).getResultList();
    }
}