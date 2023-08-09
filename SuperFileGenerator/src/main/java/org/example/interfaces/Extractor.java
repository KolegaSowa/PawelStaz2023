package org.example.interfaces;

import java.util.List;

public interface Extractor {
    void extract(String path, List<String> fieldName, List<String> fieldsValue) throws Exception;
}
