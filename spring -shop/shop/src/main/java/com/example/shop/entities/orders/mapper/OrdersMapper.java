package com.example.shop.entities.orders.mapper;

import com.example.shop.dto.AddressDTO;
import com.example.shop.dto.OrdersDTO;
import com.example.shop.entities.address.model.Address;
import com.example.shop.entities.orders.model.Orders;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdersMapper {

    Orders dtoToEntity(OrdersDTO ordersDTO);

    List<Orders> dtoToEntity(List<OrdersDTO> ordersDTOS);

    OrdersDTO entityToDTO(Orders orders);

    List<OrdersDTO> entityToDTO(List<Orders> orders);
}
