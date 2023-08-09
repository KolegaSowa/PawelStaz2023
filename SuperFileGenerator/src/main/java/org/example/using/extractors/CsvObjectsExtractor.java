package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.CsvWriter;

import java.lang.reflect.Field;

public class CsvObjectsExtractor implements Extractor {

    @Override
    public void extract(String path, Field[] allFieldsInStructure, String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject) {

        new CsvWriter().generateFile(path, fieldName, fieldsValue, sizeOfListWithObject);
    }
}