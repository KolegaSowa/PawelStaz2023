package com.example.shop.entities.historyofchange.mapper;

import com.example.shop.dto.HistoryOfChangeDTO;
import com.example.shop.entities.historyofchange.model.HistoryOfChange;
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
public class HistoryOfChangeMapperImpl implements HistoryOfChangeMapper {

    @Override
    public HistoryOfChange dtoToEntity(HistoryOfChangeDTO historyOfChangeDTO) {
        if ( historyOfChangeDTO == null ) {
            return null;
        }

        HistoryOfChange.HistoryOfChangeBuilder historyOfChange = HistoryOfChange.builder();

        historyOfChange.idOfHistoryOfChange( historyOfChangeDTO.getIdOfHistoryOfChange() );
        historyOfChange.product( historyOfChangeDTO.getProduct() );
        historyOfChange.employee( historyOfChangeDTO.getEmployee() );
        historyOfChange.oldPrice( historyOfChangeDTO.getOldPrice() );
        historyOfChange.newPrice( historyOfChangeDTO.getNewPrice() );
        historyOfChange.dateOfChange( historyOfChangeDTO.getDateOfChange() );

        return historyOfChange.build();
    }

    @Override
    public List<HistoryOfChange> dtoToEntity(List<HistoryOfChangeDTO> historyOfChangeDTOS) {
        if ( historyOfChangeDTOS == null ) {
            return null;
        }

        List<HistoryOfChange> list = new ArrayList<HistoryOfChange>( historyOfChangeDTOS.size() );
        for ( HistoryOfChangeDTO historyOfChangeDTO : historyOfChangeDTOS ) {
            list.add( dtoToEntity( historyOfChangeDTO ) );
        }

        return list;
    }

    @Override
    public HistoryOfChangeDTO entityToDTO(HistoryOfChange historyOfChange) {
        if ( historyOfChange == null ) {
            return null;
        }

        HistoryOfChangeDTO historyOfChangeDTO = new HistoryOfChangeDTO();

        historyOfChangeDTO.setIdOfHistoryOfChange( historyOfChange.getIdOfHistoryOfChange() );
        historyOfChangeDTO.setProduct( historyOfChange.getProduct() );
        historyOfChangeDTO.setEmployee( historyOfChange.getEmployee() );
        historyOfChangeDTO.setOldPrice( historyOfChange.getOldPrice() );
        historyOfChangeDTO.setNewPrice( historyOfChange.getNewPrice() );
        historyOfChangeDTO.setDateOfChange( historyOfChange.getDateOfChange() );

        return historyOfChangeDTO;
    }

    @Override
    public List<HistoryOfChangeDTO> entityToDTO(List<HistoryOfChange> historyOfChanges) {
        if ( historyOfChanges == null ) {
            return null;
        }

        List<HistoryOfChangeDTO> list = new ArrayList<HistoryOfChangeDTO>( historyOfChanges.size() );
        for ( HistoryOfChange historyOfChange : historyOfChanges ) {
            list.add( entityToDTO( historyOfChange ) );
        }

        return list;
    }
}
