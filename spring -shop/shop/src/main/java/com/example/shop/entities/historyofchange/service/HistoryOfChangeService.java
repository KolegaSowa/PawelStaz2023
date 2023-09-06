package com.example.shop.entities.historyofchange.service;

import com.example.shop.dto.HistoryOfChangeDTO;
import com.example.shop.entities.employee.model.Employee;
import com.example.shop.entities.product.model.Product;

import java.text.SimpleDateFormat;
import java.util.List;

public interface HistoryOfChangeService {
    List<HistoryOfChangeDTO> getHistoryOfChange();

    void addHistoryOfChange(HistoryOfChangeDTO historyOfChangeDTO);

    void deleteHistoryOfChange(Long idHistoryOfChange);

    void updateHistoryOfChange(Long idOfHistoryOfChange, Product product, Employee employee, float oldPrice, float newPrice, SimpleDateFormat dateOfChange);

    List<HistoryOfChangeDTO> getAuditHistoryOfChange(Long idOfHistoryOfChange);
}
