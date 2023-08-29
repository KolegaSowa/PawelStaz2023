--liquibase formatted sql
--changeset pawel:1
CREATE TABLE Employee (
    ID_Employee BIGINT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    Last_Name VARCHAR(255),
    ID_Role BIGINT,
    ID_Employee_Data BIGINT,
    FOREIGN KEY (ID_Role) REFERENCES Role(ID_Role),
    FOREIGN KEY (ID_Employee_Data) REFERENCES EmployeeData(ID_Employee_Data)
);
