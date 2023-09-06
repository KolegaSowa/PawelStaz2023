package com.example.shop.entities.productandcart.mapper;

import com.example.shop.dto.ProductAndCartDTO;
import com.example.shop.entities.product.model.Product;
import com.example.shop.entities.productandcart.model.ProductAndCart;
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
public class ProductAndCartMapperImpl implements ProductAndCartMapper {

    @Override
    public ProductAndCart dtoToEntity(ProductAndCartDTO productAndCartDTO) {
        if ( productAndCartDTO == null ) {
            return null;
        }

        ProductAndCart.ProductAndCartBuilder productAndCart = ProductAndCart.builder();

        productAndCart.idProductAndCart( productAndCartDTO.getIdProductAndCart() );
        List<Product> list = productAndCartDTO.getProducts();
        if ( list != null ) {
            productAndCart.products( new ArrayList<Product>( list ) );
        }
        productAndCart.price( productAndCartDTO.getPrice() );
        productAndCart.amount( productAndCartDTO.getAmount() );

        return productAndCart.build();
    }

    @Override
    public List<ProductAndCart> dtoToEntity(List<ProductAndCartDTO> productAndCartDTOS) {
        if ( productAndCartDTOS == null ) {
            return null;
        }

        List<ProductAndCart> list = new ArrayList<ProductAndCart>( productAndCartDTOS.size() );
        for ( ProductAndCartDTO productAndCartDTO : productAndCartDTOS ) {
            list.add( dtoToEntity( productAndCartDTO ) );
        }

        return list;
    }

    @Override
    public ProductAndCartDTO entityToDTO(ProductAndCart productAndCart) {
        if ( productAndCart == null ) {
            return null;
        }

        ProductAndCartDTO productAndCartDTO = new ProductAndCartDTO();

        productAndCartDTO.setIdProductAndCart( productAndCart.getIdProductAndCart() );
        List<Product> list = productAndCart.getProducts();
        if ( list != null ) {
            productAndCartDTO.setProducts( new ArrayList<Product>( list ) );
        }
        productAndCartDTO.setPrice( productAndCart.getPrice() );
        productAndCartDTO.setAmount( productAndCart.getAmount() );

        return productAndCartDTO;
    }

    @Override
    public List<ProductAndCartDTO> entityToDTO(List<ProductAndCart> productAndCarts) {
        if ( productAndCarts == null ) {
            return null;
        }

        List<ProductAndCartDTO> list = new ArrayList<ProductAndCartDTO>( productAndCarts.size() );
        for ( ProductAndCart productAndCart : productAndCarts ) {
            list.add( entityToDTO( productAndCart ) );
        }

        return list;
    }
}
