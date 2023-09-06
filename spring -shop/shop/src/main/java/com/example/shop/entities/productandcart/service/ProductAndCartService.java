package com.example.shop.entities.productandcart.service;

import com.example.shop.dto.ProductAndCartDTO;
import com.example.shop.entities.product.model.Product;

import java.util.List;

public interface ProductAndCartService {
    List<ProductAndCartDTO> getProductAndCart();

    void addProductAndCart(ProductAndCartDTO productAndCartDTO);

    void deleteProductAndCart(Long idProductAndCart);

    void updateProductAndCart(Long idProductAndCart, List<Product> products, float price, int amount);

    List<ProductAndCartDTO> getAuditProductAndCart(Long idProductAndCart);
}