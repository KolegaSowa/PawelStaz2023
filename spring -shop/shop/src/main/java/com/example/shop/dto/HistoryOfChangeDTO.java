package com.example.shop.dto;

import com.example.shop.entities.employee.model.Employee;
import com.example.shop.entities.product.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;

@Getter
@Setter
@NoArgsConstructor
public class HistoryOfChangeDTO {

    private long idOfHistoryOfChange;
    private Product product;
    private Employee employee;
    private float oldPrice;
    private float newPrice;
    private SimpleDateFormat dateOfChange;
}