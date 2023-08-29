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

@ToString
@Getter
@Setter
@Entity
@Audited
public class Role {
    @Column(name = "ID_Role")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRole;

    @Column(name = "Employee_Role")
    private String employeeRole;
}
