package com.example.shop.entities.product.mapper;

import com.example.shop.dto.ProductDTO;
import com.example.shop.entities.product.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T11:22:18+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product dtoToEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.idProduct( productDTO.getIdProduct() );
        product.name( productDTO.getName() );
        product.price( productDTO.getPrice() );
        product.amount( productDTO.getAmount() );
        product.vat( productDTO.getVat() );
        product.uniqueID( productDTO.getUniqueID() );

        return product.build();
    }

    @Override
    public List<Product> dtoToEntity(List<ProductDTO> productDTOS) {
        if ( productDTOS == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDTOS.size() );
        for ( ProductDTO productDTO : productDTOS ) {
            list.add( dtoToEntity( productDTO ) );
        }

        return list;
    }

    @Override
    public ProductDTO entityToDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setIdProduct( product.getIdProduct() );
        productDTO.setName( product.getName() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setAmount( product.getAmount() );
        productDTO.setVat( product.getVat() );
        productDTO.setUniqueID( product.getUniqueID() );

        return productDTO;
    }

    @Override
    public List<ProductDTO> entityToDTO(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( entityToDTO( product ) );
        }

        return list;
    }
}
