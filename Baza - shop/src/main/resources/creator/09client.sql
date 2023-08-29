--liquibase formatted sql
--changeset pawel:1
CREATE TABLE Client (
    ID_Client BIGINT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    Last_Name VARCHAR(255),
    ID_Cart BIGINT,
    ID_Address BIGINT,
    ID_Client_Data INT,
    ID_Order BIGINT,
    FOREIGN KEY (ID_Cart) REFERENCES Cart(ID_Cart),
    FOREIGN KEY (ID_Address) REFERENCES Address(ID_Address),
    FOREIGN KEY (ID_Client_Data) REFERENCES ClientData(ID_Client_Data)
);