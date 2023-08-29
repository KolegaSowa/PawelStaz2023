--liquibase formatted sql
--changeset pawel:1
CREATE TABLE ProductAndOrder (
    ID_ProductAndOrder BIGINT AUTO_INCREMENT PRIMARY KEY,
    ID_Product BIGINT,
    ID_Order BIGINT,
    FOREIGN KEY (ID_Product) REFERENCES Product(ID_Product),
    FOREIGN KEY (ID_Order) REFERENCES Orders(ID_Order)
);