package com.example.shop.entities.clientdata.repository;

import com.example.shop.entities.clientdata.model.ClientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDataRepository extends JpaRepository<ClientData, Long> {
}
