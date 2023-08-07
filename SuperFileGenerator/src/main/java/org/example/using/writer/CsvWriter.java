package org.example.using.writer;

import com.opencsv.CSVWriter;
import org.example.interfaces.GenerateFile;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter implements GenerateFile {
    @Override
    public void generateFile(String path, String[] fieldsName, String[] fieldsValue, int sizeOfListWithObject) {
        try {

            FileWriter fileWriter = new FileWriter(path);
            CSVWriter csvWriter = new CSVWriter(fileWriter, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.DEFAULT_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);


            int sizeOfArray = fieldsName.length;


            String[] headerRecords = new String[sizeOfArray];
            for (int i = 0; i < sizeOfArray; i++) {
                headerRecords[i] = fieldsName[i];
            }
            csvWriter.writeNext(headerRecords);


            String[][] records = new String[sizeOfListWithObject][sizeOfArray];
            for (int i = 0; i < fieldsValue.length; i++) {
                int recordsIndex = i / sizeOfArray;
                int innerIndex = i % sizeOfArray;
                records[recordsIndex][innerIndex] = fieldsValue[i];
            }

            for (int i = 0; i < sizeOfListWithObject; i++) {
                csvWriter.writeNext(records[i]);
            }


            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
