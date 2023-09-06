package com.example.shop.entities.productandorder.mapper;

import com.example.shop.dto.ProductAndOrderDTO;
import com.example.shop.entities.productandorder.model.ProductAndOrder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductAndOrderMapper {

    ProductAndOrder dtoToEntity(ProductAndOrderDTO productAndOrderDTO);

    List<ProductAndOrder> dtoToEntity(List<ProductAndOrderDTO> productAndOrderDTOS);

    ProductAndOrderDTO entityToDTO(ProductAndOrder productAndOrder);

    List<ProductAndOrderDTO> entityToDTO(List<ProductAndOrder> productAndOrders);
}
