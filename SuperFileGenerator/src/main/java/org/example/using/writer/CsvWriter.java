package org.example.using.writer;

import com.opencsv.CSVWriter;
import org.example.interfaces.FileGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter implements FileGenerator {

    @Override
    public void generateFile(String path, List<String> fieldsName, List<String> fieldsValue) {
        try (FileWriter fileWriter = new FileWriter(path); CSVWriter csvWriter = new CSVWriter(fileWriter)) {

            csvWriter.writeNext(fieldsName.toArray(new String[0]));
            for (int indexOfValue = 0; indexOfValue < fieldsValue.size(); indexOfValue += fieldsName.size()) {
                List<String> rowValues = fieldsValue.subList(indexOfValue, indexOfValue + fieldsName.size());
                csvWriter.writeNext(rowValues.toArray(new String[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}