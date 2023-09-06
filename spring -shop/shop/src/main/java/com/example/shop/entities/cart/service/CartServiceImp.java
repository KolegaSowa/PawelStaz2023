package com.example.shop.entities.cart.service;

import com.example.shop.dto.CartDTO;
import com.example.shop.entities.cart.mapper.CartMapper;
import com.example.shop.entities.cart.model.Cart;
import com.example.shop.entities.cart.repository.CartRepository;
import com.example.shop.entities.productandcart.model.ProductAndCart;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
class CartServiceImp implements CartService {

    private final CartRepository cartRepository;
    private final AuditReader auditReader;
    private final CartMapper cartMapper;

    @Override
    public List<CartDTO> getCart() {
        return cartMapper.entityToDto(cartRepository.findAll());
    }

    @Override
    public void addCart(CartDTO cartDTO) {
        cartRepository.save(cartMapper.dtoToEntity(cartDTO));
    }

    @Override
    public void deleteCart(Long idCart) {
        boolean exist = cartRepository.existsById(idCart);
        if (!exist) {
            throw new IllegalStateException(
                    "Cart with id" + idCart + "does not exist");
        }
        cartRepository.deleteById(idCart);
    }

    @Override
    public void updateCart(Long idCart, ProductAndCart productAndCart) {
        if (cartRepository.findById(idCart).isPresent()) {
            CartDTO cartDTO = cartMapper.entityToDto(cartRepository.findById(idCart).get()) ;
            cartDTO.setProductAndCart(productAndCart);
            cartRepository.save(cartMapper.dtoToEntity(cartDTO));
        } else {
            System.out.println("Cart with id " + idCart + " does not exist");
        }
    }

    @Override
    public List<CartDTO> getAuditCart(Long idCart) {
        return auditReader.createQuery().forRevisionsOfEntity(Cart.class, true, true).getResultList();
    }
}