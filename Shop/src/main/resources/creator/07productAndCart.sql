--liquibase formatted sql
--changeset pawel:1
CREATE TABLE ProductAndCart (
    ID_Product_And_Cart BIGINT AUTO_INCREMENT PRIMARY KEY,
    Price FLOAT,
    Amount INT,
    ID_Product BIGINT,
    FOREIGN KEY (ID_Product) REFERENCES Product(ID_Product)
);
