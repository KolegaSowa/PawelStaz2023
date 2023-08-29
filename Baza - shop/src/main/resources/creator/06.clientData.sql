--liquibase formatted sql
--changeset pawel:1
CREATE TABLE ClientData (
    ID_Client_Data INT AUTO_INCREMENT PRIMARY KEY,
    Login VARCHAR(255),
    Password VARCHAR(255),
    Email VARCHAR(255),
    Phone INT
);
