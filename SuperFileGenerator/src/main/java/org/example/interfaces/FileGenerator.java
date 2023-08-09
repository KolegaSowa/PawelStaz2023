package org.example.interfaces;

import java.util.List;

public interface FileGenerator {
    void generateFile(String path, List<String> fieldsName, List<String> fieldsValue) throws Exception;
}