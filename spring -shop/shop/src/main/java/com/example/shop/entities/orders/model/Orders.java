package com.example.shop.entities.orders.model;

import com.example.shop.entities.client.model.Client;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Audited
public class Orders {

    @Column(name = "id_order")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrder;

    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;
}