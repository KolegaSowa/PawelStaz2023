package com.example.shop.entities.orders.repository;

import com.example.shop.entities.orders.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
