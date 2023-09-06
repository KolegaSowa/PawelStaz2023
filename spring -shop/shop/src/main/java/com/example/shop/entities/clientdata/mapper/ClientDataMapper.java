package com.example.shop.entities.clientdata.mapper;

import com.example.shop.entities.clientdata.model.ClientData;
import com.example.shop.dto.ClientDataDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientDataMapper {

    ClientData dtoToEntity(ClientDataDTO clientDataDTO);

    List<ClientData> dtoToEntity(List<ClientDataDTO> clientDataDTOS);

    ClientDataDTO entityToDTO(ClientData clientData);

    List<ClientDataDTO> entityToDTO(List<ClientData> clientData);
}