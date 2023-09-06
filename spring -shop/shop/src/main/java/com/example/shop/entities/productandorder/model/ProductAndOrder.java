package com.example.shop.entities.productandorder.model;

import com.example.shop.entities.orders.model.Orders;
import com.example.shop.entities.product.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class ProductAndOrder {

    @Column(name = "id_product_and_order")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProductAndOrder;

    @OneToMany
    @ToString.Exclude
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "id_order")
    private Orders orders;
}