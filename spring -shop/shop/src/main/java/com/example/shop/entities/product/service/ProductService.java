package com.example.shop.entities.product.service;

import com.example.shop.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProduct();

    void addProduct(ProductDTO productDTO);

    void deleteProduct(Long idProduct);

    void updateProduct(Long idProduct, String name, float price, int amount, float vat, long uniqueID);

    List<ProductDTO> getAuditProduct(Long idProduct);
}
