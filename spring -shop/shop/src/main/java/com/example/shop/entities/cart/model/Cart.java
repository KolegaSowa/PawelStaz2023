package com.example.shop.entities.cart.model;

import com.example.shop.entities.productandcart.model.ProductAndCart;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Audited
public class Cart {

    @Column(name = "id_cart")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCart;

    @OneToOne
    @JoinColumn(name =  "id_product_and_cart")
    private ProductAndCart productAndCart;
}
