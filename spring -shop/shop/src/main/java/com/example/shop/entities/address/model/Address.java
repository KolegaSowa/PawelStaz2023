package com.example.shop.entities.address.model;

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
public class Address {

    @Column(name = "id_address")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAddress;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "building_number")
    private String buildingNumber;

    @Column(name = "apartment_number")
    private String apartmentNumber;

    @Column(name = "is_main")
    private boolean isMain;

}