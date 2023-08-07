package org.example.interfaces;

import java.lang.reflect.Field;
import java.util.List;

public interface Extractor {
    void extractor(String path, Field[] allFieldsInStructure, String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject) throws Exception;
}
