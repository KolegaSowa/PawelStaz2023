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

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Audited
public class Client {

    @Column(name = "ID_Client")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;

    @Column(name = "Name")
    private String nameClient;

    @Column(name = "Last_Name")
    private String lastNameClient;

    @OneToOne
    @JoinColumn(name = "ID_Cart")
    private Cart cart;

    @OneToMany
    private List<Address> addresses = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "ID_Client_Data")
    private ClientData clientData;

    @OneToMany
    private List<Orders> orders = new ArrayList<>();


}