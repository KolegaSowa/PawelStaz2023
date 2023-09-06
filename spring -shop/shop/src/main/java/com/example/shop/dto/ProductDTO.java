package com.example.shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private long idProduct;
    private String name;
    private float price;
    private int amount;
    private float vat;
    private long uniqueID;
}
