package org.example.using;

import lombok.NoArgsConstructor;
import org.example.using.extractors.*;
import java.lang.reflect.Field;

@NoArgsConstructor
public class ObjectExtractorChooser {

    private static ObjectExtractorChooser instance;

    public static synchronized ObjectExtractorChooser getInstance() {
        if (instance == null) {
            instance = new ObjectExtractorChooser();
        }
        return instance;
    }

    protected void chooseGenerator(String extension, String path, Field[] allFieldsInStructure,
                                   String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject) throws Exception {

        switch (extension) {
            case "csv" ->
                    new CsvObjectsExtractor().extract(path, allFieldsInStructure, fieldName, fieldsValue, lengthFieldsValue, sizeOfListWithObject);

            case "xml" ->
                    new XmlObjectsExtractor().extract(path, allFieldsInStructure, fieldName, fieldsValue, lengthFieldsValue, sizeOfListWithObject);

            case "xlsx" ->
                    new XlsxObjectsExtractor().extract(path, allFieldsInStructure, fieldName, fieldsValue, lengthFieldsValue, sizeOfListWithObject);

            case "json" ->
                    new JsonObjectsExtractor().extract(path, allFieldsInStructure, fieldName, fieldsValue, lengthFieldsValue, sizeOfListWithObject);

            case "yaml" ->
                    new YamlObjectsExtractor().extract(path, allFieldsInStructure, fieldName, fieldsValue, lengthFieldsValue, sizeOfListWithObject);

            default -> System.out.println("This type is not supported");
        }
    }
}