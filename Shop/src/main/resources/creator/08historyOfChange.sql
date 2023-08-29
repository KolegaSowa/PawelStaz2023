--liquibase formatted sql
--changeset pawel:1
CREATE TABLE HistoryOfChange (
    ID_History BIGINT AUTO_INCREMENT PRIMARY KEY,
    ID_Product BIGINT,
    ID_Employee BIGINT,
    Old_Price FLOAT,
    New_Price FLOAT,
    Date_Of_Change DATE,
    FOREIGN KEY (ID_Product) REFERENCES Product(ID_Product),
    FOREIGN KEY (ID_Employee) REFERENCES Employee(ID_Employee)
);
