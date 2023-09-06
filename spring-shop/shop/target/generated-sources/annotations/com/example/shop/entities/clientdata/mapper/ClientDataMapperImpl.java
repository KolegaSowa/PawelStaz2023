package com.example.shop.entities.clientdata.mapper;

import com.example.shop.dto.ClientDataDTO;
import com.example.shop.entities.clientdata.model.ClientData;
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
public class ClientDataMapperImpl implements ClientDataMapper {

    @Override
    public ClientData dtoToEntity(ClientDataDTO clientDataDTO) {
        if ( clientDataDTO == null ) {
            return null;
        }

        ClientData.ClientDataBuilder clientData = ClientData.builder();

        clientData.idClientData( clientDataDTO.getIdClientData() );
        clientData.clientLogin( clientDataDTO.getClientLogin() );
        clientData.clientPassword( clientDataDTO.getClientPassword() );
        clientData.clientEmail( clientDataDTO.getClientEmail() );
        clientData.phone( clientDataDTO.getPhone() );

        return clientData.build();
    }

    @Override
    public List<ClientData> dtoToEntity(List<ClientDataDTO> clientDataDTOS) {
        if ( clientDataDTOS == null ) {
            return null;
        }

        List<ClientData> list = new ArrayList<ClientData>( clientDataDTOS.size() );
        for ( ClientDataDTO clientDataDTO : clientDataDTOS ) {
            list.add( dtoToEntity( clientDataDTO ) );
        }

        return list;
    }

    @Override
    public ClientDataDTO entityToDTO(ClientData clientData) {
        if ( clientData == null ) {
            return null;
        }

        ClientDataDTO clientDataDTO = new ClientDataDTO();

        clientDataDTO.setIdClientData( clientData.getIdClientData() );
        clientDataDTO.setClientLogin( clientData.getClientLogin() );
        clientDataDTO.setClientPassword( clientData.getClientPassword() );
        clientDataDTO.setClientEmail( clientData.getClientEmail() );
        clientDataDTO.setPhone( clientData.getPhone() );

        return clientDataDTO;
    }

    @Override
    public List<ClientDataDTO> entityToDTO(List<ClientData> clientData) {
        if ( clientData == null ) {
            return null;
        }

        List<ClientDataDTO> list = new ArrayList<ClientDataDTO>( clientData.size() );
        for ( ClientData clientData1 : clientData ) {
            list.add( entityToDTO( clientData1 ) );
        }

        return list;
    }
}
