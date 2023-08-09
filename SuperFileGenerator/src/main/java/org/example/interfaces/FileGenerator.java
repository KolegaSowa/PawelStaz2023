package org.example.interfaces;

public interface FileGenerator {
    void generateFile(String path, String[] fieldsName, String[] fieldsValue, int sizeOfListWithObject) throws Exception;
}