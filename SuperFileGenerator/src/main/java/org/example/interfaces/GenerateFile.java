package org.example.interfaces;

public interface GenerateFile<T> {
    void generateFile(String path, String[] fieldsName, String[] fieldsValue, int sizeOfListWithObject) throws Exception;
}