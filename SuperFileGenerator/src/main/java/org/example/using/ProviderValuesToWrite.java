package org.example.using;

import lombok.NoArgsConstructor;
import org.example.interfaces.Extractor;
import org.example.using.extractors.*;

@NoArgsConstructor
public class ProviderValuesToWrite {

    private static ProviderValuesToWrite instance;

    public static synchronized ProviderValuesToWrite getInstance() {
        if (instance == null) {
            instance = new ProviderValuesToWrite();
        }
        return instance;
    }

    protected Extractor chooseGenerator(String extension) {

        switch (extension) {
            case "csv" -> {
                return new CsvObjectsExtractor();
            }

            case "xml" -> {
                return new XmlObjectsExtractor();
            }

            case "xlsx" -> {
                return new XlsxObjectsExtractor();
            }

            case "json" -> {
                return new JsonObjectsExtractor();
            }

            case "yaml" -> {
                return new YamlObjectsExtractor();
            }

            default -> System.out.println("This type is not supported");
        }
        return null;
    }
}