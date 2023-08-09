package org.example.using.writer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.example.interfaces.FileGenerator;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;

public class XlsxWriter implements FileGenerator {

    @Override
    public void generateFile(String path, String[] fieldsName, String[] fieldsValue, int sizeOfListWithObject) throws Exception {

        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet();

            int sizeOfArray = fieldsName.length;

            Row headerRow = sheet.createRow(0);

            for (int numberOfHeaderCell = 0; numberOfHeaderCell < sizeOfArray; numberOfHeaderCell++) {
                headerRow.createCell(numberOfHeaderCell).setCellValue(fieldsName[numberOfHeaderCell]);
            }

            String[][] records = new String[sizeOfListWithObject][sizeOfArray];
            for (int numberOfValueCell = 0; numberOfValueCell < fieldsValue.length; numberOfValueCell++) {
                int recordsIndex = numberOfValueCell / sizeOfArray;
                int innerIndex = numberOfValueCell % sizeOfArray;
                records[recordsIndex][innerIndex] = fieldsValue[numberOfValueCell];
            }

            for (int numberOfRows = 0; numberOfRows < sizeOfListWithObject; numberOfRows++) {
                Row row = sheet.createRow(numberOfRows + 1);
                for (int cellIndex = 0; cellIndex < sizeOfArray; cellIndex++) {
                    row.createCell(cellIndex).setCellValue(records[numberOfRows][cellIndex]);
                }
            }

            OutputStream fileOutput = Files.newOutputStream(new File(path).toPath());
            workbook.write(fileOutput);
        }
    }
}