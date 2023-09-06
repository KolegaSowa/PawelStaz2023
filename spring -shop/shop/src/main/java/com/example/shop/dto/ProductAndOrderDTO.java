package com.example.shop.dto;

import com.example.shop.entities.orders.model.Orders;
import com.example.shop.entities.product.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductAndOrderDTO {

    private long idProductAndOrder;
    private List<Product> products;
    private Orders orders;
}
