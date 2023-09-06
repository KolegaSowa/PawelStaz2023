package com.example.shop.entities.client.model;

import com.example.shop.entities.clientdata.model.ClientData;
import com.example.shop.entities.orders.model.Orders;
import com.example.shop.entities.address.model.Address;
import com.example.shop.entities.cart.model.Cart;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Audited
public class Client {

    @Column(name = "id_client")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;

    @Column(name = "name")
    private String nameClient;

    @Column(name = "last_name")
    private String lastNameClient;

    @OneToOne
    @JoinColumn(name = "id_cart")
    private Cart cart;

    @OneToMany
    @ToString.Exclude
    private List<Address> addresses = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_client_data")
    private ClientData clientData;

    @OneToMany
    @ToString.Exclude
    private List<Orders> orders = new ArrayList<>();

}