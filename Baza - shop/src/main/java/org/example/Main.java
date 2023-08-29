package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.example.table.Address;
import org.example.table.Client;
import org.example.table.ClientData;
import org.example.table.Employee;
import org.example.table.EmployeeData;
import org.example.table.Product;
import org.example.table.Role;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String name1 = "Sowixon";
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "validate");

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(name1), properties);

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            //Dodawanie produktu
            Product product = new Product();
            product.setPrice(12);
            product.setVat(0.1f);
            product.setName("Azbest");
            product.setUniqueID(12345);
            product.setAmount(1);
            em.persist(product);

            //Dodawanie roli dla pracowników
            Role role = new Role();
            role.setEmployeeRole("Kapitan");
            em.persist(role);

            //Wyświetlanie pola o id = 1
            var s = em.find(Role.class, 1);
            System.out.println(s);

            //Dodanie nowych danych pracownika
            EmployeeData employeeData = new EmployeeData();
            employeeData.setEmailEmployee("tytus.bomba.pl");
            employeeData.setPasswordEmployee("orzel1");
            employeeData.setLoginEmployee("gwiezdnaFlota");
            em.persist(employeeData);

            //Pobieranie danych
            Role roleInBase = em.getReference(Role.class, 1);
            EmployeeData employeeDataInBase = em.getReference(EmployeeData.class, 1);

            //Dodanie nowego pracownika
            Employee employee = new Employee();
            employee.setNameEmployee("Tytus");
            employee.setLastNameEmployee("Bomba");
            employee.setRole(roleInBase);
            employee.setEmployeeData(employeeDataInBase);

            em.persist(employee);

            //Dodanie danych klienta
            ClientData clientData = new ClientData();
            clientData.setPhone(123456789);
            clientData.setClientEmail("michal.glus@wp.pl");
            clientData.setClientPassword("sylwia123");
            clientData.setClientLogin("kapitan");

            em.persist(clientData);

            ClientData clientDataInBase = em.getReference(ClientData.class, 5);

            //Dodanie adresu klienta
            Address address = new Address();
            address.setMain(true);
            address.setStreet("XYZ");
            address.setCity("XDDD");
            address.setCountry("Polska");
            address.setApartmentNumber("1b");
            address.setBuildingNumber("12");
            address.setZipCode("123-111");

            em.persist(address);

            Address addressInDataBase = em.getReference(Address.class, 0);

            //Dodanie klienta
            Client client = new Client();
            client.setIdClient(1);
            client.setClientData(clientDataInBase);
            client.setLastNameClient("Głuś");
            client.setNameClient("Michał");
            client.setAddresses(List.of(addressInDataBase));

            em.persist(client);


            em.getTransaction().commit();
        }
    }
}