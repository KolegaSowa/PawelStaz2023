package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.CsvWriter;

import java.lang.reflect.Field;


public class CsvObjectsExtractor<T> implements Extractor {
    @Override
    public void extractor(String path, Field[] allFieldsInStructure, String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject) {

        sendToFileGenerator(path, fieldName, fieldsValue, sizeOfListWithObject);
    }

    private void sendToFileGenerator(String path, String[] fieldsName, String[] fieldsValue, int sizeOfListWithObject) {

        new CsvWriter().generateFile(path, fieldsName, fieldsValue, sizeOfListWithObject);
    }
}