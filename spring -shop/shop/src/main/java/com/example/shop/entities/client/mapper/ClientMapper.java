package com.example.shop.entities.client.mapper;

import com.example.shop.entities.client.model.Client;
import com.example.shop.dto.ClientDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client dtoToEntity(ClientDTO clientDTO);

    List<Client> dtoToEntity(List<ClientDTO> clientDTOS);

    ClientDTO entityToDTO(Client client);

    List<ClientDTO> entityToDTO(List<Client> clients);
}
