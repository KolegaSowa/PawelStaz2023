package org.example.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
@Audited
public class Product {

    @Column(name = "ID_Product")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduct;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private float price;

    @Column(name = "Amount")
    private int amount;

    @Column(name = "VAT")
    private float vat;

    @Column(name = "Unique_ID")
    private long uniqueID;
}