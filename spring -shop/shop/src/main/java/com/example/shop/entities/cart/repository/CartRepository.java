package com.example.shop.entities.cart.repository;

import com.example.shop.entities.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
