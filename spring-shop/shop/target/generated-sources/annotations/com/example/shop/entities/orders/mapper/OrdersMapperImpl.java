package com.example.shop.entities.orders.mapper;

import com.example.shop.dto.OrdersDTO;
import com.example.shop.entities.orders.model.Orders;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T10:50:20+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class OrdersMapperImpl implements OrdersMapper {

    @Override
    public Orders dtoToEntity(OrdersDTO ordersDTO) {
        if ( ordersDTO == null ) {
            return null;
        }

        Orders.OrdersBuilder orders = Orders.builder();

        orders.idOrder( ordersDTO.getIdOrder() );
        orders.client( ordersDTO.getClient() );

        return orders.build();
    }

    @Override
    public List<Orders> dtoToEntity(List<OrdersDTO> ordersDTOS) {
        if ( ordersDTOS == null ) {
            return null;
        }

        List<Orders> list = new ArrayList<Orders>( ordersDTOS.size() );
        for ( OrdersDTO ordersDTO : ordersDTOS ) {
            list.add( dtoToEntity( ordersDTO ) );
        }

        return list;
    }

    @Override
    public OrdersDTO entityToDTO(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersDTO ordersDTO = new OrdersDTO();

        ordersDTO.setIdOrder( orders.getIdOrder() );
        ordersDTO.setClient( orders.getClient() );

        return ordersDTO;
    }

    @Override
    public List<OrdersDTO> entityToDTO(List<Orders> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrdersDTO> list = new ArrayList<OrdersDTO>( orders.size() );
        for ( Orders orders1 : orders ) {
            list.add( entityToDTO( orders1 ) );
        }

        return list;
    }
}
