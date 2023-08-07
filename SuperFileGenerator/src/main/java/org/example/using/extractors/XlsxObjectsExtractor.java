package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.XlsxWriter;

import java.lang.reflect.Field;


public class XlsxObjectsExtractor<T> implements Extractor {
    @Override
    public void extractor(String path, Field[] allFieldsInStructure, String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject) throws Exception {

        sendToFileGenerator(path, fieldName, fieldsValue, sizeOfListWithObject);

    }


    private void sendToFileGenerator(String path, String[] fieldsName, String[] fieldsValue, int sizeOfListWithObject) throws Exception {
        XlsxWriter xlsxWriter = new XlsxWriter();
        xlsxWriter.generateFile(path, fieldsName, fieldsValue, sizeOfListWithObject);
    }
}

