package com.example.shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDataDTO {

    private long idClientData;
    private String clientLogin;
    private String clientPassword;
    private String clientEmail;
    private int phone;
}
