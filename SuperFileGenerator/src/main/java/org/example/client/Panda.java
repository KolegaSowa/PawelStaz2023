package org.example.client;

public class Panda extends Animal {
    private String name;
    private String color;

    public Panda(String localization, String species, int age, String name, String color) {
        super(localization, species, age);
        this.name = name;
        this.color = color;
    }
}

