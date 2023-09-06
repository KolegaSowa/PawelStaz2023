package com.example.shop.entities.address.service;

import com.example.shop.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> getAddress();

    void addAddress(AddressDTO addressDTO);

    void deleteAddress(Long idAddress);

    void updateAddress(Long idAddress, String country, String zipCode, String city, String street, String buildingNumber, String apartmentNumber, boolean isMain);

    List<AddressDTO> getAuditAddress(Long idAddress);
}