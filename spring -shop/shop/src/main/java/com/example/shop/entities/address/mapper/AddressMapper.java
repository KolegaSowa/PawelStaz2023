package com.example.shop.entities.address.mapper;

import com.example.shop.entities.address.model.Address;
import com.example.shop.dto.AddressDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address dtoToEntity(AddressDTO addressDTO);

    List<Address> dtoToEntity(List<AddressDTO> addressDTOS);

    AddressDTO entityToDTO(Address address);

    List<AddressDTO> entityToDTO(List<Address> addresses);
}