package org.example.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

@Getter
@Setter
@ToString
@Entity
@Audited
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Employee_Data")
    private long idEmployeeData;

    @Column(name = "Login")
    private String loginEmployee;

    @Column(name = "Password")
    private String passwordEmployee;

    @Column(name = "Email")
    private String emailEmployee;
}