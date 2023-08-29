package org.example.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.List;

@Getter
@Setter
@Entity
@Audited
public class ProductAndCart {

    @Column(name = "ID_Product_And_Cart")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProductAndCart;

    @OneToMany
    private List<Product> products;

    @Column(name = "Price")
    private float price;

    @Column(name = "Amount")
    private int amount;
}