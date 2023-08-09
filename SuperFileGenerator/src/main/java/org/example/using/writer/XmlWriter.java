package org.example.using.writer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlWriter {

    public void generateFile(String path, String[] fieldName, String[] fieldsValue, int sizeOfListWithObject)
            throws ParserConfigurationException, FileNotFoundException, TransformerException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();

        int indexBooster = 0;
        int counter = 0;

        Element root = document.createElement("Objects");
        document.appendChild(root);

        for (int numberOfRow = 0; numberOfRow < sizeOfListWithObject; numberOfRow++) {
            for (int numberOfColumn = 0; numberOfColumn < fieldName.length; numberOfColumn++) {
                if (numberOfRow > 0 && counter == 5) {
                    indexBooster = indexBooster + fieldName.length;
                    counter = 0;
                }
                Element field = document.createElement(fieldName[numberOfColumn]);
                field.setTextContent(fieldsValue[numberOfColumn + indexBooster]);
                root.appendChild(field);

                counter++;
            }
        }

        FileOutputStream outputStream = new FileOutputStream(path);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(outputStream);

        transformer.transform(source, result);
    }
}