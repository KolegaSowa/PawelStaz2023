package com.example.shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {

    private long idAddress;
    private String country;
    private String zipCode;
    private String city;
    private String street;
    private String buildingNumber;
    private String apartmentNumber;
    private boolean isMain;
}