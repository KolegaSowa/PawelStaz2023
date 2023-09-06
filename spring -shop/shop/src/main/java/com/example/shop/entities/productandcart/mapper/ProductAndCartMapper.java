package com.example.shop.entities.productandcart.mapper;

import com.example.shop.dto.ProductAndCartDTO;
import com.example.shop.entities.productandcart.model.ProductAndCart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductAndCartMapper {

    ProductAndCart dtoToEntity(ProductAndCartDTO productAndCartDTO);

    List<ProductAndCart> dtoToEntity(List<ProductAndCartDTO> productAndCartDTOS);

    ProductAndCartDTO entityToDTO(ProductAndCart productAndCart);

    List<ProductAndCartDTO> entityToDTO(List<ProductAndCart> productAndCarts);
}
