package com.example.shop.entities.productandorder.service;

import com.example.shop.dto.ProductAndOrderDTO;
import com.example.shop.entities.orders.model.Orders;
import com.example.shop.entities.product.model.Product;
import com.example.shop.entities.productandorder.mapper.ProductAndOrderMapper;
import com.example.shop.entities.productandorder.repository.ProductAndOrderRepository;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
class ProductAndOrderServiceImp implements ProductAndOrderService {

    private final ProductAndOrderRepository productAndOrderRepository;
    private final AuditReader auditReader;
    private final ProductAndOrderMapper productAndOrderMapper;

    @Override
    public List<ProductAndOrderDTO> getProductAndOrder() {
        return productAndOrderMapper.entityToDTO(productAndOrderRepository.findAll());
    }

    @Override
    public void addProductAndOrder(ProductAndOrderDTO productAndOrderDTO) {
        productAndOrderRepository.save(productAndOrderMapper.dtoToEntity(productAndOrderDTO));
    }

    @Override
    public void deleteProductAndOrder(Long idProductAndOrder) {
        boolean exist = productAndOrderRepository.existsById(idProductAndOrder);
        if (!exist) {
            throw new IllegalStateException(
                    "ProductAndOrder with id " + idProductAndOrder + " does not exist");
        }
        productAndOrderRepository.deleteById(idProductAndOrder);
    }

    @Override
    public void updateProductAndOrder(Long idProductAndOrder, List<Product> products, Orders orders) {
        if (productAndOrderRepository.findById(idProductAndOrder).isPresent()) {
            ProductAndOrderDTO productAndOrderDTO = productAndOrderMapper.entityToDTO(productAndOrderRepository.findById(idProductAndOrder).get());
            productAndOrderDTO.setProducts(products);
            productAndOrderDTO.setOrders(orders);
            productAndOrderRepository.save(productAndOrderMapper.dtoToEntity(productAndOrderDTO));
        } else {
            System.out.println("ProductAndOrder with id " + idProductAndOrder + " does not exist");
        }
    }

    @Override
    public List<ProductAndOrderDTO> getAuditProductAndOrder(Long idProductAndOrder) {
        return auditReader.createQuery().forRevisionsOfEntity(ProductAndOrderDTO.class, true, true).getResultList();
    }
}
