package com.example.shop.entities.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Product {

    @Column(name = "id_product")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduct;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "amount")
    private int amount;

    @Column(name = "vat")
    private float vat;

    @Column(name = "unique_id")
    private long uniqueID;
}