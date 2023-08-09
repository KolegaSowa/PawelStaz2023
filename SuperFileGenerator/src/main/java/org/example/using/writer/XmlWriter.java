package org.example.using.writer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class XmlWriter {

    public void generateFile(String path, List<String> fieldName, List<String> fieldsValue)
            throws ParserConfigurationException, FileNotFoundException, TransformerException {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("data");
            doc.appendChild(rootElement);

            for (int i = 0; i < fieldName.size(); i++) {
                Element fieldElement = doc.createElement("field");
                rootElement.appendChild(fieldElement);

                Element nameElement = doc.createElement("name field");
                nameElement.appendChild(doc.createTextNode(fieldName.get(i)));
                fieldElement.appendChild(nameElement);

                Element valuesElement = doc.createElement("values");
                fieldElement.appendChild(valuesElement);

                String[] values = fieldsValue.get(i).split(",");
                for (String value : values) {
                    Element valueElement = doc.createElement("value");
                    valueElement.appendChild(doc.createTextNode(value));
                    valuesElement.appendChild(valueElement);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(path));

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}