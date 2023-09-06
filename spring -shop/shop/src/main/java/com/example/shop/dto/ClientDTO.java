package com.example.shop.dto;

import com.example.shop.entities.address.model.Address;
import com.example.shop.entities.cart.model.Cart;
import com.example.shop.entities.clientdata.model.ClientData;
import com.example.shop.entities.orders.model.Orders;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {

    private long idClient;
    private String nameClient;
    private String lastNameClient;
    private Cart cart;
    private List<Address> addresses = new ArrayList<>();
    private ClientData clientData;
    private List<Orders> orders = new ArrayList<>();
}