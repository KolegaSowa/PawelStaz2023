package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.XlsxWriter;

import java.util.List;

public class XlsxObjectsExtractor implements Extractor {

    @Override
    public void extract(String path, List<String> fieldName, List<String> fieldsValue)
            throws Exception {

        new XlsxWriter().generateFile(path, fieldName, fieldsValue);
    }
}

