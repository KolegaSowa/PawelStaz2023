package org.example.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
@Audited
public class Cart {

    @Column(name = "ID_Cart")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCart;

    @OneToOne
    @JoinColumn(name =  "ID_Product_And_Cart")
    private ProductAndCart productAndCart;
}
