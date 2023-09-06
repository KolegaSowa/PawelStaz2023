package com.example.shop.entities.cart.mapper;

import com.example.shop.dto.CartDTO;
import com.example.shop.entities.cart.model.Cart;
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
public class CartMapperImpl implements CartMapper {

    @Override
    public Cart dtoToEntity(CartDTO cartDTO) {
        if ( cartDTO == null ) {
            return null;
        }

        Cart.CartBuilder cart = Cart.builder();

        cart.idCart( cartDTO.getIdCart() );
        cart.productAndCart( cartDTO.getProductAndCart() );

        return cart.build();
    }

    @Override
    public List<Cart> dtoToEntity(List<CartDTO> cartDTOS) {
        if ( cartDTOS == null ) {
            return null;
        }

        List<Cart> list = new ArrayList<Cart>( cartDTOS.size() );
        for ( CartDTO cartDTO : cartDTOS ) {
            list.add( dtoToEntity( cartDTO ) );
        }

        return list;
    }

    @Override
    public CartDTO entityToDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDTO cartDTO = new CartDTO();

        cartDTO.setIdCart( cart.getIdCart() );
        cartDTO.setProductAndCart( cart.getProductAndCart() );

        return cartDTO;
    }

    @Override
    public List<CartDTO> entityToDto(List<Cart> carts) {
        if ( carts == null ) {
            return null;
        }

        List<CartDTO> list = new ArrayList<CartDTO>( carts.size() );
        for ( Cart cart : carts ) {
            list.add( entityToDto( cart ) );
        }

        return list;
    }
}
