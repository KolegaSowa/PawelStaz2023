package com.example.shop.entities.employeedata.repository;

import com.example.shop.entities.employeedata.model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeData, Long> {
}
