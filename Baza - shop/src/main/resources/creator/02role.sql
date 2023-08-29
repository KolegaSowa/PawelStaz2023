--liquibase formatted sql
--changeset pawel:1
CREATE TABLE Role (
    ID_Role BIGINT AUTO_INCREMENT PRIMARY KEY,
    Employee_Role VARCHAR(255)
);
