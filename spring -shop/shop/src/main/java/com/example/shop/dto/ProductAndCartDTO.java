package com.example.shop.dto;

import com.example.shop.entities.product.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductAndCartDTO {

    private long idProductAndCart;
    private List<Product> products;
    private float price;
    private int amount;
}
