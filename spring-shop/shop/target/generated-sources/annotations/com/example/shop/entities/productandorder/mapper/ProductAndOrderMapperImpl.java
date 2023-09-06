package com.example.shop.entities.productandorder.mapper;

import com.example.shop.dto.ProductAndOrderDTO;
import com.example.shop.entities.product.model.Product;
import com.example.shop.entities.productandorder.model.ProductAndOrder;
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
public class ProductAndOrderMapperImpl implements ProductAndOrderMapper {

    @Override
    public ProductAndOrder dtoToEntity(ProductAndOrderDTO productAndOrderDTO) {
        if ( productAndOrderDTO == null ) {
            return null;
        }

        ProductAndOrder.ProductAndOrderBuilder productAndOrder = ProductAndOrder.builder();

        productAndOrder.idProductAndOrder( productAndOrderDTO.getIdProductAndOrder() );
        List<Product> list = productAndOrderDTO.getProducts();
        if ( list != null ) {
            productAndOrder.products( new ArrayList<Product>( list ) );
        }
        productAndOrder.orders( productAndOrderDTO.getOrders() );

        return productAndOrder.build();
    }

    @Override
    public List<ProductAndOrder> dtoToEntity(List<ProductAndOrderDTO> productAndOrderDTOS) {
        if ( productAndOrderDTOS == null ) {
            return null;
        }

        List<ProductAndOrder> list = new ArrayList<ProductAndOrder>( productAndOrderDTOS.size() );
        for ( ProductAndOrderDTO productAndOrderDTO : productAndOrderDTOS ) {
            list.add( dtoToEntity( productAndOrderDTO ) );
        }

        return list;
    }

    @Override
    public ProductAndOrderDTO entityToDTO(ProductAndOrder productAndOrder) {
        if ( productAndOrder == null ) {
            return null;
        }

        ProductAndOrderDTO productAndOrderDTO = new ProductAndOrderDTO();

        productAndOrderDTO.setIdProductAndOrder( productAndOrder.getIdProductAndOrder() );
        List<Product> list = productAndOrder.getProducts();
        if ( list != null ) {
            productAndOrderDTO.setProducts( new ArrayList<Product>( list ) );
        }
        productAndOrderDTO.setOrders( productAndOrder.getOrders() );

        return productAndOrderDTO;
    }

    @Override
    public List<ProductAndOrderDTO> entityToDTO(List<ProductAndOrder> productAndOrders) {
        if ( productAndOrders == null ) {
            return null;
        }

        List<ProductAndOrderDTO> list = new ArrayList<ProductAndOrderDTO>( productAndOrders.size() );
        for ( ProductAndOrder productAndOrder : productAndOrders ) {
            list.add( entityToDTO( productAndOrder ) );
        }

        return list;
    }
}
