package com.example.shop.dto;

import com.example.shop.entities.client.model.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrdersDTO {

    private long idOrder;
    private Client client;
}
