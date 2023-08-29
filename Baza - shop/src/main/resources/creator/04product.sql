--liquibase formatted sql
--changeset pawel:1
CREATE TABLE Product (
    ID_Product BIGINT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    Price FLOAT,
    Amount INT,
    VAT FLOAT,
    Unique_ID BIGINT
);
