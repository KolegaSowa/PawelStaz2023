package com.example.shop.entities.productandorder.service;

import com.example.shop.dto.ProductAndOrderDTO;
import com.example.shop.entities.orders.model.Orders;
import com.example.shop.entities.product.model.Product;

import java.util.List;

public interface ProductAndOrderService {
    List<ProductAndOrderDTO> getProductAndOrder();

    void addProductAndOrder(ProductAndOrderDTO productAndOrderDTO);

    void deleteProductAndOrder(Long idProductAndOrder);

    void updateProductAndOrder(Long idProductAndOrder, List<Product> products, Orders orders);

    List<ProductAndOrderDTO> getAuditProductAndOrder(Long idProductAndOrder);
}
