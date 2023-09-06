package com.example.shop.entities.productandcart.model;

import com.example.shop.entities.product.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Audited
public class ProductAndCart {

    @Column(name = "id_product_and_cart")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProductAndCart;

    @OneToMany
    @ToString.Exclude
    private List<Product> products;

    @Column(name = "price")
    private float price;

    @Column(name = "amount")
    private int amount;
}