package com.example.shop.entities.client.mapper;

import com.example.shop.dto.ClientDTO;
import com.example.shop.entities.address.model.Address;
import com.example.shop.entities.client.model.Client;
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
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client dtoToEntity(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setIdClient( clientDTO.getIdClient() );
        client.setNameClient( clientDTO.getNameClient() );
        client.setLastNameClient( clientDTO.getLastNameClient() );
        client.setCart( clientDTO.getCart() );
        List<Address> list = clientDTO.getAddresses();
        if ( list != null ) {
            client.setAddresses( new ArrayList<Address>( list ) );
        }
        client.setClientData( clientDTO.getClientData() );
        List<Orders> list1 = clientDTO.getOrders();
        if ( list1 != null ) {
            client.setOrders( new ArrayList<Orders>( list1 ) );
        }

        return client;
    }

    @Override
    public List<Client> dtoToEntity(List<ClientDTO> clientDTOS) {
        if ( clientDTOS == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( clientDTOS.size() );
        for ( ClientDTO clientDTO : clientDTOS ) {
            list.add( dtoToEntity( clientDTO ) );
        }

        return list;
    }

    @Override
    public ClientDTO entityToDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setIdClient( client.getIdClient() );
        clientDTO.setNameClient( client.getNameClient() );
        clientDTO.setLastNameClient( client.getLastNameClient() );
        clientDTO.setCart( client.getCart() );
        List<Address> list = client.getAddresses();
        if ( list != null ) {
            clientDTO.setAddresses( new ArrayList<Address>( list ) );
        }
        clientDTO.setClientData( client.getClientData() );
        List<Orders> list1 = client.getOrders();
        if ( list1 != null ) {
            clientDTO.setOrders( new ArrayList<Orders>( list1 ) );
        }

        return clientDTO;
    }

    @Override
    public List<ClientDTO> entityToDTO(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( clients.size() );
        for ( Client client : clients ) {
            list.add( entityToDTO( client ) );
        }

        return list;
    }
}
