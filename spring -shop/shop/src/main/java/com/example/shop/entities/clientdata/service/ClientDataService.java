package com.example.shop.entities.clientdata.service;

import com.example.shop.dto.ClientDataDTO;

import java.util.List;

public interface ClientDataService {
    List<ClientDataDTO> getClientData();

    void addClientData(String clientLogin, String clientPassword, String clientEmail, int phone);

    void deleteClientData(Long idClientData);

    void updateClientData(Long idClientData, String clientLogin, String clientPassword, String clientEmail, int phone);

    List<ClientDataDTO> getAuditClientData(Long idClientData);
}