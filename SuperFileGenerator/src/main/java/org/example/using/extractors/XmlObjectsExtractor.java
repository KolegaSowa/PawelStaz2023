package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.XmlWriter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;

public class XmlObjectsExtractor implements Extractor {

    @Override
    public void extractor(String path, Field[] allFieldsInStructure, String[] fieldName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject)
            throws ParserConfigurationException, FileNotFoundException, TransformerException {

        sendToFileGenerator(path,fieldName,fieldsValue,sizeOfListWithObject);
    }

    private void sendToFileGenerator(String path, String[] fieldName, String[] fieldsValue, int sizeOfListWithObject)
            throws ParserConfigurationException, FileNotFoundException, TransformerException {

        new XmlWriter().generateFile(path,fieldName,fieldsValue,sizeOfListWithObject);
    }
}