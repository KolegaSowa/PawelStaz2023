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
public class ClientData {

    @Column(name = "ID_Client_Data")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClientData;

    @Column(name = "Login")
    private String clientLogin;

    @Column(name = "Password")
    private String clientPassword;

    @Column(name = "Email")
    private String clientEmail;

    @Column(name = "Phone")
    private int phone;
}
