package com.example.shop.entities.cart.service;

import com.example.shop.dto.CartDTO;
import com.example.shop.entities.productandcart.model.ProductAndCart;

import java.util.List;

public interface CartService {
    List<CartDTO> getCart();

    void addCart(CartDTO cartDTO);

    void deleteCart(Long idCart);

    void updateCart(Long idCart, ProductAndCart productAndCart);

    List<CartDTO> getAuditCart(Long idCart);
}