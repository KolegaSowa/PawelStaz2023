package org.example.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
@Audited
public class Address {

    @Column(name = "ID_Address")
    @Id
    private long idAddress;

    @Column(name = "Country")
    private String country;

    @Column(name = "Zip_Code")
    private String zipCode;

    @Column(name = "City")
    private String city;

    @Column(name = "Street")
    private String street;

    @Column(name = "Building_Number")
    private String buildingNumber;

    @Column(name = "Apartment_Number")
    private String apartmentNumber;

    @Column(name = "Is_Main")
    private boolean isMain;
}