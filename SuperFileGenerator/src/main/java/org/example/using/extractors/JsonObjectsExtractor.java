package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Field;

public class JsonObjectsExtractor implements Extractor {

    @Override
    public void extractor(String path, Field[] allFieldsInStructure, String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject) throws Exception {

        sendToFileWriter(path, fieldName, fieldsValue, sizeOfListWithObject);
    }

    private void sendToFileWriter(String path, String[] fieldsName, String[] fieldsValue, int sizeOfListWithObject) throws IOException {

        new JsonWriter().generateFile(path, fieldsName, fieldsValue, sizeOfListWithObject);
    }


}