package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.CsvWriter;

import java.util.List;

public class CsvObjectsExtractor implements Extractor {

    @Override
    public void extract(String path, List<String> fieldName, List<String> fieldsValue) {

        new CsvWriter().generateFile(path, fieldName, fieldsValue);
    }
}