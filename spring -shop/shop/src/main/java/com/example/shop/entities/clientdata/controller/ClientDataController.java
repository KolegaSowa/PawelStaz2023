package com.example.shop.entities.clientdata.controller;

import com.example.shop.dto.ClientDataDTO;
import com.example.shop.entities.clientdata.service.ClientDataService;
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
@RequestMapping(path = "/clientData")
public class ClientDataController {

    private final ClientDataService clientDataService;

    @GetMapping
    public List<ClientDataDTO> getClientData() {
        return clientDataService.getClientData();
    }

    @PostMapping
    public void addClientData(@RequestBody ClientDataDTO clientDataDTO) {
        clientDataService.addClientData(clientDataDTO.getClientLogin(), clientDataDTO.getClientPassword(), clientDataDTO.getClientEmail(), clientDataDTO.getPhone());
    }

    @DeleteMapping(path = "{id_client_data}")
    public void deleteClientData(@PathVariable("id_client_data") Long idClientData) {
        clientDataService.deleteClientData(idClientData);
    }

    @PutMapping("/update/{idClientData}")
    public void updateClientData(@PathVariable long idClientData, @RequestBody ClientDataDTO clientDataDTO) {
        clientDataService.updateClientData(idClientData, clientDataDTO.getClientLogin(), clientDataDTO.getClientPassword(), clientDataDTO.getClientEmail(), clientDataDTO.getPhone());
    }

    @GetMapping("/audited/{idClientData}")
    List<ClientDataDTO> getAuditClientData(@PathVariable long idClientData) {
        return clientDataService.getAuditClientData(idClientData);
    }
}