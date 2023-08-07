package org.example;

import org.example.client.Panda;
import org.example.using.ManagerFileOperations;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Panda> pandaList = new ArrayList<>();
        pandaList.add(new Panda("Gdańsk", "Panda Wielka", 15, "Bobo", "czarno-biala"));
        pandaList.add(new Panda("Wrocław", "Panda Mała", 18, "Bibi", "rudy"));
        pandaList.add(new Panda("Poznań", "Panda Mała", 11, "Bunia", "rudy"));

        String pathPanda1 = "C:\\Users\\pzientara\\Desktop\\csv_file\\TablePandaCSV.csv";

        String pathPanda2 = "C:\\Users\\pzientara\\Desktop\\csv_file\\TablePandaXLSX.xlsx";

        String pathPanda3 = "C:\\Users\\pzientara\\Desktop\\csv_file\\TablePandaYAML.yaml";

        String pathPanda4 = "C:\\Users\\pzientara\\Desktop\\csv_file\\TablePandaJSON.json";

        String pathPanda5 = "C:\\Users\\pzientara\\Desktop\\csv_file\\TablePandaXML.xml";

        ManagerFileOperations managerFileOperations = ManagerFileOperations.getInstance();

        managerFileOperations.writeFile(pathPanda1, pandaList, Panda.class);
        managerFileOperations.writeFile(pathPanda2, pandaList, Panda.class);
        managerFileOperations.writeFile(pathPanda3, pandaList, Panda.class);
        managerFileOperations.writeFile(pathPanda4, pandaList, Panda.class);
        managerFileOperations.writeFile(pathPanda5, pandaList, Panda.class);

        //managerFileOperations.readFile(pathPanda1);
    }
}