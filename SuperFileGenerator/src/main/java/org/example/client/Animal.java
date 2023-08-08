package org.example.client;

public class Animal extends Zoo {

    private String species;
    private int age;

    public Animal(String localization, String species, int age) {
        super(localization);
        this.species = species;
        this.age = age;
    }
}
