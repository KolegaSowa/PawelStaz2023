package org.example.interfaces;

import java.lang.reflect.Field;

public interface Extractor {
    void extract(String path, Field[] allFieldsInStructure, String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject) throws Exception;
}
