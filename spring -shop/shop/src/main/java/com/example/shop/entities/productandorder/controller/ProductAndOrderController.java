package com.example.shop.entities.productandorder.controller;

import com.example.shop.dto.ProductAndOrderDTO;
import com.example.shop.entities.productandorder.service.ProductAndOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/productAndOrder")
class ProductAndOrderController {

    private final ProductAndOrderService productAndOrderService;

    @GetMapping
    public List<ProductAndOrderDTO> getProductAndOrder() {
        return productAndOrderService.getProductAndOrder();
    }

    @PostMapping
    public void addProductAndOrder(@RequestBody ProductAndOrderDTO productAndOrderDTO) {
        productAndOrderService.addProductAndOrder(productAndOrderDTO);
    }

    @DeleteMapping(path = "{id_product_and_order}")
    public void deleteProductAndOrder(@PathVariable("id_product_and_order") Long idProductAndOrder) {
        productAndOrderService.deleteProductAndOrder(idProductAndOrder);
    }

    @PutMapping("/update/{idProductAndOrder}")
    public void updateProductAndOrder(@PathVariable long idProductAndOrder, @RequestBody ProductAndOrderDTO productAndOrderDTO) {
        productAndOrderService.updateProductAndOrder(idProductAndOrder, productAndOrderDTO.getProducts(), productAndOrderDTO.getOrders());
    }

    @GetMapping("/audited/{idProductAndOrder}")
    List<ProductAndOrderDTO> getAuditedProductAndOrder(@PathVariable long idProductAndOrder) {
        return productAndOrderService.getAuditProductAndOrder(idProductAndOrder);
    }
}
