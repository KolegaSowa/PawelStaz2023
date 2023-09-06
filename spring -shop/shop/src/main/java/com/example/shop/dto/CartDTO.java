package com.example.shop.dto;

import com.example.shop.entities.productandcart.model.ProductAndCart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartDTO {
    private long idCart;
    private ProductAndCart productAndCart;
}
