package com.example.shop.entities.client.service;

import com.example.shop.dto.ClientDTO;
import com.example.shop.entities.address.model.Address;
import com.example.shop.entities.cart.model.Cart;
import com.example.shop.entities.clientdata.model.ClientData;
import com.example.shop.entities.orders.model.Orders;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getClient();

    void addClient(ClientDTO clientDTO);

    void deleteClient(Long idClient);

    void updateClient(Long idClient, String nameClient, String lastNameClient, Cart cart, List<Address> addresses, ClientData clientData, List<Orders> orders);

    List<ClientDTO> getAuditClient(Long idClient);
}
