package org.example.using;

import org.example.using.reader.*;

public class ChooserFileToRead {
    protected void chooseReader(String extended, String path) throws Exception {

        switch (extended){
            case "csv":
                CsvReader csvReader = new CsvReader();
                csvReader.readFile(path);
                break;
            case "xlsx":
                XlsxReader xlsxReader = new XlsxReader();
                xlsxReader.readFile(path);
                break;
            case "json":
                JsonReader jsonReader = new JsonReader();
                jsonReader.readFile(path);
                break;
            case "yaml":
                YamlReader yamlReader = new YamlReader();
                yamlReader.readFile(path);
                break;
            case "xml":
                XmlReader xmlReader = new XmlReader();
                xmlReader.readFile(path);
                break;
            default:
                System.out.println("File not found");
        }
    }
}