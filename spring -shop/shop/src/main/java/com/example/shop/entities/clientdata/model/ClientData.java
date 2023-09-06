package com.example.shop.entities.clientdata.model;

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
public class ClientData {

    @Column(name = "id_client_data")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClientData;

    @Column(name = "login")
    private String clientLogin;

    @Column(name = "password")
    private String clientPassword;

    @Column(name = "email")
    private String clientEmail;

    @Column(name = "phone")
    private int phone;
}
