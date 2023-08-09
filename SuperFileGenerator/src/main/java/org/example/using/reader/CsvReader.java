package org.example.using.reader;

import org.example.interfaces.DocumentFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader implements DocumentFileReader {

    public final String delimiter = ",";

    @Override
    public void readFile(String path) {
        File file = new File(path);

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line;
            String[] tempArr;
            while ((line = bufferedReader.readLine()) != null) {
                tempArr = line.split(delimiter);
                for (String tempStr : tempArr) {
                    System.out.print(tempStr + " ");
                }
                System.out.println();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}