package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.XlsxWriter;

import java.lang.reflect.Field;


public class XlsxObjectsExtractor implements Extractor {

    @Override
    public void extractor(String path, Field[] allFieldsInStructure, String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject) throws Exception {

        sendToFileGenerator(path, fieldName, fieldsValue, sizeOfListWithObject);
    }

    private void sendToFileGenerator(String path, String[] fieldsName, String[] fieldsValue, int sizeOfListWithObject) throws Exception {

        new XlsxWriter().generateFile(path, fieldsName, fieldsValue, sizeOfListWithObject);
    }
}

