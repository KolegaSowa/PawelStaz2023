package org.example.using;

import lombok.NoArgsConstructor;
import org.example.interfaces.DocumentFileReader;
import org.example.using.reader.CsvReader;
import org.example.using.reader.JsonReader;
import org.example.using.reader.XlsxReader;
import org.example.using.reader.XmlReader;
import org.example.using.reader.YamlReader;

@NoArgsConstructor
public class ProviderFileToRead {

    private static ProviderFileToRead instance;

    public static synchronized ProviderFileToRead getInstance() {
        if (instance == null) {
            instance = new ProviderFileToRead();
        }
        return instance;
    }

    public DocumentFileReader chooseReader(String extension) {

        switch (extension) {
            case "csv" -> {
                return new CsvReader();
            }

            case "xml" -> {
                return new XmlReader();
            }

            case "xlsx" -> {
                return new XlsxReader();
            }

            case "json" -> {
                return new JsonReader();
            }

            case "yaml" ->{
                return  new YamlReader();
            }

            default -> System.out.println("File not found");
        }
        return null;
    }
}