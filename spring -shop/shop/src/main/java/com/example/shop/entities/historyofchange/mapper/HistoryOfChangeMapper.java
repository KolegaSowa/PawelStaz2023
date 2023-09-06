package com.example.shop.entities.historyofchange.mapper;

import com.example.shop.dto.HistoryOfChangeDTO;
import com.example.shop.entities.historyofchange.model.HistoryOfChange;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoryOfChangeMapper {

    HistoryOfChange dtoToEntity(HistoryOfChangeDTO historyOfChangeDTO);

    List<HistoryOfChange> dtoToEntity(List<HistoryOfChangeDTO> historyOfChangeDTOS);

    HistoryOfChangeDTO entityToDTO(HistoryOfChange historyOfChange);

    List<HistoryOfChangeDTO> entityToDTO(List<HistoryOfChange> historyOfChanges);
}
