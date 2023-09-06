package com.example.shop.entities.client.controller;

import com.example.shop.dto.ClientDTO;
import com.example.shop.entities.client.service.ClientService;
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
@RequestMapping(path = "/client")
class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<ClientDTO> getClient() {
        return clientService.getClient();
    }

    @PostMapping
    public void addClient(@RequestBody ClientDTO clientDTO) {
        clientService.addClient(clientDTO);
    }

    @DeleteMapping(path = "{id_client}")
    public void deleteClient(@PathVariable("id_client") Long idClient) {
        clientService.deleteClient(idClient);
    }

    @PutMapping("/update/{idClient}")
    public void updateClient(@PathVariable long idClient, @RequestBody ClientDTO clientDTO) {
        clientService.updateClient(
                idClient, clientDTO.getNameClient(), clientDTO.getLastNameClient(), clientDTO.getCart(), clientDTO.getAddresses(), clientDTO.getClientData(), clientDTO.getOrders());
    }

    @GetMapping("/audited/{idClient}")
    List<ClientDTO> getAuditClient(@PathVariable long idClient) {
        return clientService.getAuditClient(idClient);
    }
}