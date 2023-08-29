--liquibase formatted sql
--changeset pawel:1
CREATE TABLE EmployeeData (
    ID_Employee_Data BIGINT AUTO_INCREMENT PRIMARY KEY,
    Login VARCHAR(255),
    Password VARCHAR(255),
    Email VARCHAR(255)
);
