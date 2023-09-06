package com.example.shop.entities.orders.service;

import com.example.shop.dto.OrdersDTO;
import com.example.shop.entities.client.model.Client;

import java.util.List;

public interface OrdersService {
    List<OrdersDTO> getOrders();

    void addOrders(OrdersDTO ordersDTO);

    void deleteOrder(Long idOrder);

    void updaterOrders(Long idOrder, Client client);

    List<OrdersDTO> getAuditOrder(Long idOrder);
}