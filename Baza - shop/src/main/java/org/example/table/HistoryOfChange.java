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

import java.text.SimpleDateFormat;

@Getter
@Setter
@Entity
@Audited
public class HistoryOfChange {

    @Column(name = "ID_History")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOfHistoryOfChange;

    @OneToOne
    @JoinColumn(name = "ID_Product")
    private Product product;

    @OneToOne
    @JoinColumn(name = "ID_Employee")
    private Employee employee;

    @Column(name = "Old_Price")
    private float oldPrice;

    @Column(name = "New_Price")
    private float newPrice;

    @Column(name = "Date_Of_Change")
    private SimpleDateFormat dateOfChange;
}