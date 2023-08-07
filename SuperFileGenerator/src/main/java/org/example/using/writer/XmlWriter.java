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

    public void generateFile(String path, String[] fieldName, String[] fieldsValue, int sizeOfListWithObject) throws ParserConfigurationException, FileNotFoundException, TransformerException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();

        int indexBooster = 0;
        int counter = 0;

        Element root = document.createElement("Objects");
        document.appendChild(root);

        for (int i = 0; i < sizeOfListWithObject; i++) {
            for (int j = 0; j < fieldName.length; j++) {
                if (i > 0 && counter == 5) {
                    indexBooster = indexBooster + fieldName.length;
                    counter = 0;
                }
                Element field = document.createElement(fieldName[j]);
                field.setTextContent(fieldsValue[j + indexBooster]);
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