package org.example.using;

import org.example.using.reader.*;

public class ChooserFileToRead {

    private static ChooserFileToRead instance;

    private ChooserFileToRead() {
    }

    public static synchronized ChooserFileToRead getInstance() {
        if (instance == null) {
            instance = new ChooserFileToRead();
        }
        return instance;
    }

    protected void chooseReader(String extended, String path) throws Exception {

        switch (extended) {
            case "csv" -> new CsvReader().readFile(path);

            case "xml" -> new XmlReader().readFile(path);

            case "xlsx" -> new XlsxReader().readFile(path);

            case "json" -> new JsonReader().readFile(path);

            case "yaml" -> new YamlReader().readFile(path);

            default -> System.out.println("File not found");
        }
    }
}