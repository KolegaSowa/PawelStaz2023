package com.example.shop.entities.productandcart.service;

import com.example.shop.dto.ProductAndCartDTO;
import com.example.shop.entities.product.model.Product;
import com.example.shop.entities.productandcart.mapper.ProductAndCartMapper;
import com.example.shop.entities.productandcart.model.ProductAndCart;
import com.example.shop.entities.productandcart.repository.ProductAndCartRepository;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
class ProductAndCartServiceImp implements ProductAndCartService {

    private final ProductAndCartRepository productAndCartRepository;
    private final AuditReader auditReader;
    private final ProductAndCartMapper productAndCartMapper;

    @Override
    public List<ProductAndCartDTO> getProductAndCart() {
        return productAndCartMapper.entityToDTO(productAndCartRepository.findAll());
    }

    @Override
    public void addProductAndCart(ProductAndCartDTO productAndCartDTO) {
        productAndCartRepository.save(productAndCartMapper.dtoToEntity(productAndCartDTO));
    }

    @Override
    public void deleteProductAndCart(Long idProductAndCart) {
        boolean exist = productAndCartRepository.existsById(idProductAndCart);
        if (!exist) {
            throw new IllegalStateException(
                    "ProductAndCart with id " + idProductAndCart + " does not exist");
        }
        productAndCartRepository.deleteById(idProductAndCart);
    }

    @Override
    public void updateProductAndCart(Long idProductAndCart, List<Product> products, float price, int amount) {
        if (productAndCartRepository.findById(idProductAndCart).isPresent()) {
            ProductAndCartDTO productAndCartDTO = productAndCartMapper.entityToDTO(productAndCartRepository.findById(idProductAndCart).get());
            productAndCartDTO.setProducts(products);
            productAndCartDTO.setAmount(amount);
            productAndCartDTO.setPrice(price);
            productAndCartRepository.save(productAndCartMapper.dtoToEntity(productAndCartDTO));
        } else {
            System.out.println("ProductAndCart with id " + idProductAndCart + " does not exist");
        }
    }

    @Override
    public List<ProductAndCartDTO> getAuditProductAndCart(Long idProductAndCart) {
        return auditReader.createQuery().forRevisionsOfEntity(ProductAndCart.class, true, true).getResultList();
    }
}
