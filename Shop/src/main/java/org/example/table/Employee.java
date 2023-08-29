package org.example.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

@ToString
@Getter
@Setter
@Entity
@Audited
public class Employee {

    @Column(name = "ID_Employee")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmployee;

    @Column(name = "Name")
    private String nameEmployee;

    @Column(name = "Last_Name")
    private String lastNameEmployee;

    @ManyToOne
    @JoinColumn(name =  "ID_Role")
    private Role role;

    @OneToOne
    @JoinColumn(name = "ID_Employee_Data")
    private EmployeeData employeeData;
}