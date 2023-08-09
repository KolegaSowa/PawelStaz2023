package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.XlsxWriter;

import java.lang.reflect.Field;

public class XlsxObjectsExtractor implements Extractor {

    @Override
    public void extract(String path, Field[] allFieldsInStructure, String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject)
            throws Exception {

        new XlsxWriter().generateFile(path, fieldName, fieldsValue, sizeOfListWithObject);
    }
}

