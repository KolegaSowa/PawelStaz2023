package com.example.shop.entities.productandcart.repository;

import com.example.shop.entities.productandcart.model.ProductAndCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAndCartRepository extends JpaRepository<ProductAndCart, Long> {
}
