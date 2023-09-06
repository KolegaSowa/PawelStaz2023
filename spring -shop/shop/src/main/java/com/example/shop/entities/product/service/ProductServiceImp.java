package com.example.shop.entities.product.service;

import com.example.shop.dto.ProductDTO;
import com.example.shop.entities.product.mapper.ProductMapper;
import com.example.shop.entities.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final AuditReader auditReader;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getProduct() {
        return productMapper.entityToDTO(productRepository.findAll());
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        productRepository.save(productMapper.dtoToEntity(productDTO));
    }

    @Override
    public void deleteProduct(Long idProduct) {
        boolean exist = productRepository.existsById(idProduct);
        if (!exist) {
            throw new IllegalStateException(
                    "Product with id " + idProduct + " does not exist");
        }
        productRepository.deleteById(idProduct);
    }

    @Override
    public void updateProduct(Long idProduct, String name, float price, int amount, float vat, long uniqueID) {
        if (productRepository.findById(idProduct).isPresent()) {
            ProductDTO productDTO = productMapper.entityToDTO(productRepository.findById(idProduct).get());
            productDTO.setAmount(amount);
            productDTO.setName(name);
            productDTO.setVat(vat);
            productDTO.setPrice(price);
            productDTO.setUniqueID(uniqueID);
            productRepository.save(productMapper.dtoToEntity(productDTO));
        } else {
            System.out.println("Product with id " + idProduct + " does not exist");
        }
    }

    @Override
    public List<ProductDTO> getAuditProduct(Long idProduct) {
        return auditReader.createQuery().forRevisionsOfEntity(ProductDTO.class, true, true).getResultList();
    }
}
