package com.example.shop.entities.product.mapper;

import com.example.shop.dto.ProductDTO;
import com.example.shop.entities.product.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product dtoToEntity(ProductDTO productDTO);

    List<Product> dtoToEntity(List<ProductDTO> productDTOS);

    ProductDTO entityToDTO(Product product);

    List<ProductDTO> entityToDTO(List<Product> products);
}
