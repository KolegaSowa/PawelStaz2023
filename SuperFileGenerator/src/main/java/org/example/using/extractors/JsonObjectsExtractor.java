package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Field;

public class JsonObjectsExtractor implements Extractor {

    @Override
    public void extract(String path, Field[] allFieldsInStructure, String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject)
            throws Exception {

        new JsonWriter().generateFile(path, fieldName, fieldsValue, sizeOfListWithObject);
    }
}