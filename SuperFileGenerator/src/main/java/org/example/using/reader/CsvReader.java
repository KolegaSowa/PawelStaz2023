package org.example.using.reader;

import  org.example.interfaces.*;
import java.io.*;

public class CsvReader implements ReadFile {

    public final String delimiter = ",";

    @Override
    public void readFile(String path) throws Exception{
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line = " ";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                for (String tempStr : tempArr) {
                    System.out.print(tempStr + " ");
                }
                System.out.println();
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
