--liquibase formatted sql
--changeset pawel:1
CREATE TABLE Orders (
    ID_Order BIGINT AUTO_INCREMENT PRIMARY KEY,
    ID_Client BIGINT,
    FOREIGN KEY (ID_Client) REFERENCES Client(ID_Client)
);
