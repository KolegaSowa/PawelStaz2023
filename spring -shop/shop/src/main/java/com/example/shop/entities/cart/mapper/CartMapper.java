package com.example.shop.entities.cart.mapper;

import com.example.shop.entities.cart.model.Cart;
import com.example.shop.dto.CartDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    Cart dtoToEntity(CartDTO cartDTO);

    List<Cart> dtoToEntity(List<CartDTO> cartDTOS);

    CartDTO entityToDto(Cart cart);

    List<CartDTO> entityToDto(List<Cart> carts);
}
