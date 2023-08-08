package org.example.using.writer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.example.interfaces.GenerateFile;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;

public class XlsxWriter implements GenerateFile {

    @Override
    public void generateFile(String path, String[] fieldsName, String[] fieldsValue, int sizeOfListWithObject) throws Exception{
        try(Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet();

            int sizeOfArray = fieldsName.length;

            Row headerRow  = sheet.createRow(0);
            for (int i = 0; i < sizeOfArray; i++) {
               headerRow.createCell(i).setCellValue(fieldsName[i]);
            }

            String[][] records = new String[sizeOfListWithObject][sizeOfArray];
            for (int i = 0; i < fieldsValue.length; i++) {
                int recordsIndex = i / sizeOfArray;
                int innerIndex = i % sizeOfArray;
                records[recordsIndex][innerIndex] = fieldsValue[i];
            }

            for (int i = 0; i < sizeOfListWithObject; i++) {
                Row row = sheet.createRow(i+1);
                for (int j = 0; j < sizeOfArray; j++){
                    row.createCell(j).setCellValue(records[i][j]);
                }
            }

            OutputStream fileOutput = Files.newOutputStream(new File(path).toPath());
            workbook.write(fileOutput);
        }
    }
}