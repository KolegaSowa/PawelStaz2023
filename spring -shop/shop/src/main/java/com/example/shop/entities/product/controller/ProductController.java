package com.example.shop.entities.product.controller;

import com.example.shop.dto.ProductDTO;
import com.example.shop.entities.product.service.ProductService;
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
@RequestMapping(path = "/product")
class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getProduct() {
        return productService.getProduct();
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
    }

    @DeleteMapping(path = "{id_product}")
    public void deleteProduct(@PathVariable("id_product") Long idProduct) {
        productService.deleteProduct(idProduct);
    }

    @PutMapping("/update/{idProduct}")
    public void updateProduct(@PathVariable long idProduct, @RequestBody ProductDTO productDTO) {
        productService.updateProduct(idProduct, productDTO.getName(), productDTO.getPrice(), productDTO.getAmount(), productDTO.getVat(), productDTO.getUniqueID());
    }

    @GetMapping("/audited/{idProduct}")
    List<ProductDTO> getAuditRole(@PathVariable long idProduct) {
        return productService.getAuditProduct(idProduct);
    }
}
