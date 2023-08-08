package org.example.using;

import org.example.using.extractors.*;
import java.lang.reflect.Field;

public class ChooserObjectsExtractor {

    private static ChooserObjectsExtractor instance;

    private ChooserObjectsExtractor() {
    }

    public static synchronized ChooserObjectsExtractor getInstance() {
        if (instance == null) {
            instance = new ChooserObjectsExtractor();
        }
        return instance;
    }

    protected void chooseGenerator(String extended, String path, Field[] allFieldsInStructure,
                                   String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject) throws Exception {

        switch (extended) {
            case "csv" ->
                    new CsvObjectsExtractor().extractor(path, allFieldsInStructure, fieldName, fieldsValue, lengthFieldsValue, sizeOfListWithObject);

            case "xml" ->
                    new XmlObjectsExtractor().extractor(path, allFieldsInStructure, fieldName, fieldsValue, lengthFieldsValue, sizeOfListWithObject);

            case "xlsx" ->
                    new XlsxObjectsExtractor().extractor(path, allFieldsInStructure, fieldName, fieldsValue, lengthFieldsValue, sizeOfListWithObject);

            case "json" ->
                    new JsonObjectsExtractor().extractor(path, allFieldsInStructure, fieldName, fieldsValue, lengthFieldsValue, sizeOfListWithObject);

            case "yaml" ->
                    new YamlObjectsExtractor().extractor(path, allFieldsInStructure, fieldName, fieldsValue, lengthFieldsValue, sizeOfListWithObject);

            default -> System.out.println("This type is not supported");
        }
    }
}