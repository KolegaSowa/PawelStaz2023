package com.example.shop.entities.historyofchange.repository;

import com.example.shop.entities.historyofchange.model.HistoryOfChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryOfChangeRepository extends JpaRepository<HistoryOfChange, Long> {
}
