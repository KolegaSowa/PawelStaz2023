package com.example.shop.entities.historyofchange.model;

import com.example.shop.entities.product.model.Product;
import com.example.shop.entities.employee.model.Employee;
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

import java.text.SimpleDateFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Audited
public class HistoryOfChange {

    @Column(name = "id_history")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOfHistoryOfChange;

    @OneToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @OneToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @Column(name = "old_price")
    private float oldPrice;

    @Column(name = "new_price")
    private float newPrice;

    @Column(name = "date_of_change")
    private SimpleDateFormat dateOfChange;
}