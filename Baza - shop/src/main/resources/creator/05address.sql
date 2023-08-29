--liquibase formatted sql
--changeset pawel:1
CREATE TABLE Address (
    ID_Address BIGINT PRIMARY KEY,
    Country VARCHAR(255),
    Zip_Code VARCHAR(255),
    City VARCHAR(255),
    Street VARCHAR(255),
    Building_Number VARCHAR(255),
    Apartment_Number VARCHAR(255),
    Is_Main BOOLEAN
);
