package com.example.shop.entities.productandcart.controller;

import com.example.shop.dto.ProductAndCartDTO;
import com.example.shop.entities.productandcart.service.ProductAndCartService;
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
@RequestMapping(path = "/productAndCart")
class ProductAndCartController {

    private final ProductAndCartService productAndCartService;

    @GetMapping
    public List<ProductAndCartDTO> getProductAndCart() {
        return productAndCartService.getProductAndCart();
    }

    @PostMapping
    public void addProductAndCart(@RequestBody ProductAndCartDTO productAndCartDTO) {
        productAndCartService.addProductAndCart(productAndCartDTO);
    }

    @DeleteMapping(path = "{id_product_and_cart}")
    public void deleteProductAndCart(@PathVariable("id_product_and_cart") Long idProductAndCart) {
        productAndCartService.deleteProductAndCart(idProductAndCart);
    }

    @PutMapping("/update/{idProductAndCart}")
    public void updateProductAndCart(@PathVariable long idProductAndCart, @RequestBody ProductAndCartDTO productAndCartDTO) {
        productAndCartService.updateProductAndCart(idProductAndCart, productAndCartDTO.getProducts(), productAndCartDTO.getPrice(), productAndCartDTO.getAmount());
    }


    @GetMapping("audited/{idProductAndCart}")
    List<ProductAndCartDTO> getAuditProductAndCart(@PathVariable long idProductAndCart) {
        return productAndCartService.getAuditProductAndCart(idProductAndCart);
    }
}
