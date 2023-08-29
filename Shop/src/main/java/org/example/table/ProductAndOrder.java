package org.example.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.List;

@Getter
@Setter
@Entity
@Audited
public class ProductAndOrder {

    @Column(name = "ID_ProductAndOrder")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProductAndOrder;

    @OneToMany
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "ID_Order")
    private Orders orders;
}