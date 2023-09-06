package com.example.shop.entities.cart.controller;

import com.example.shop.dto.CartDTO;
import com.example.shop.entities.cart.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/cart")
class CartController {

    private final CartService cartService;

    @GetMapping
    public List<CartDTO> getAddress() {
        return cartService.getCart();
    }

    @PostMapping
    public void addCart(@RequestBody CartDTO cartDTO) {
        cartService.addCart(cartDTO);
    }

    @DeleteMapping(path = "{id_cart}")
    public void deleteCart(@PathVariable("id_cart") Long idRole) {
        cartService.deleteCart(idRole);
    }

    @PutMapping("/update/{idCart}")
    public void updateCart(@PathVariable long idCart, @RequestBody CartDTO cartDTO) {
        cartService.updateCart(idCart, cartDTO.getProductAndCart());
    }

    @GetMapping("/audited/{idCart}")
    List<CartDTO> getAuditCart(@PathVariable long idCart) {
        return cartService.getAuditCart(idCart);
    }
}