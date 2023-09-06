package com.example.shop.entities.productandorder.repository;

import com.example.shop.entities.productandorder.model.ProductAndOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAndOrderRepository extends JpaRepository<ProductAndOrder, Long> {
}
