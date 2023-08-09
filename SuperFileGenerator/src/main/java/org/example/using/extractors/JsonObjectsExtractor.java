package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.JsonWriter;

import java.util.List;

public class JsonObjectsExtractor implements Extractor {

    @Override
    public void extract(String path, List<String> fieldName, List<String> fieldsValue)
            throws Exception {

        new JsonWriter().generateFile(path, fieldName, fieldsValue);
    }
}