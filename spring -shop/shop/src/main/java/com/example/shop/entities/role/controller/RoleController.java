package com.example.shop.entities.role.controller;

import com.example.shop.dto.RoleDTO;
import com.example.shop.entities.role.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/role")
class RoleController {

    private final RoleService roleService;

    @GetMapping
    public List<RoleDTO> getRole() {
        return roleService.getRole();
    }

    @PostMapping("/add")
    public void addRole(@RequestBody RoleDTO roleDTO) {
        roleService.addRole(roleDTO);
    }

    @DeleteMapping(path = "{id_role}")
    public void deleteRole(@PathVariable("id_role") Long idRole) {
        roleService.deleteRole(idRole);
    }

    @PutMapping("/update/{idRole}")
    public void updateRole(@PathVariable long idRole, @RequestBody RoleDTO employeeRole) {
        roleService.updateRole(idRole, employeeRole.getEmployeeRole());
    }

    @GetMapping("/audited/{idRole}")
    List<RoleDTO> getAuditRole(@PathVariable long idRole) {
        return roleService.getAuditRole(idRole);
    }
}