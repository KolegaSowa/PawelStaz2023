package com.example.shop.entities.client.service;

import com.example.shop.dto.ClientDTO;
import com.example.shop.entities.address.model.Address;
import com.example.shop.entities.cart.model.Cart;
import com.example.shop.entities.client.mapper.ClientMapper;
import com.example.shop.entities.client.model.Client;
import com.example.shop.entities.client.repository.ClientRepository;
import com.example.shop.entities.clientdata.model.ClientData;
import com.example.shop.entities.orders.model.Orders;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;
    private final AuditReader auditReader;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientDTO> getClient() {
        return clientMapper.entityToDTO(clientRepository.findAll());
    }

    @Override
    public void addClient(ClientDTO clientDTO) {
        clientRepository.save(clientMapper.dtoToEntity(clientDTO));
    }

    @Override
    public void deleteClient(Long idClient) {
        boolean exist = clientRepository.existsById(idClient);
        if (!exist) {
            throw new IllegalStateException(
                    "Client with id " + idClient + " does not exist");
        }
        clientRepository.deleteById(idClient);
    }

    @Override
    public void updateClient(
            Long idClient, String nameClient, String lastNameClient, Cart cart, List<Address> addresses, ClientData clientData, List<Orders> orders) {
        if (clientRepository.findById(idClient).isPresent()) {
            ClientDTO clientDTO = clientMapper.entityToDTO(clientRepository.findById(idClient).get());
            clientDTO.setNameClient(nameClient);
            clientDTO.setLastNameClient(lastNameClient);
            clientDTO.setCart(cart);
            clientDTO.setAddresses(addresses);
            clientDTO.setClientData(clientData);
            clientDTO.setOrders(orders);
            clientRepository.save(clientMapper.dtoToEntity(clientDTO));
        } else {
            System.out.println("Client with id " + idClient + " does not exist");
        }
    }

    @Override
    public List<ClientDTO> getAuditClient(Long idClient) {
        return auditReader.createQuery().forRevisionsOfEntity(Client.class, true, true).getResultList();
    }
}