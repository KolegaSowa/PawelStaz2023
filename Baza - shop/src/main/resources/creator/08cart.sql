--liquibase formatted sql
--changeset pawel:1
CREATE TABLE Cart (
    ID_Cart BIGINT AUTO_INCREMENT PRIMARY KEY,
    ID_Product_And_Cart BIGINT,
    FOREIGN KEY (ID_Product_And_Cart) REFERENCES ProductAndCart(ID_Product_And_Cart)
);
