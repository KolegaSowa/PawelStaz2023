--liquibase formatted sql
--changeset pawel:1

ALTER TABLE Client
ADD FOREIGN KEY (ID_Order) REFERENCES Orders(ID_Order);