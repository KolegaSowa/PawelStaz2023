package org.example.using.writer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.example.interfaces.FileGenerator;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;

public class XlsxWriter implements FileGenerator {

    @Override
    public void generateFile(String path, List<String> fieldsName, List<String> fieldsValue) throws Exception {

        try (Workbook workbook = new HSSFWorkbook()) {

            Sheet sheet = workbook.createSheet();

            Row headerRow = sheet.createRow(0);

            for (int indexOfHeaderRow = 0; indexOfHeaderRow < fieldsName.size(); indexOfHeaderRow++) {
                Cell cell = headerRow.createCell(indexOfHeaderRow);
                cell.setCellValue(fieldsName.get(indexOfHeaderRow));
            }

            for (int indexOfDataRow = 0; indexOfDataRow < fieldsValue.size(); indexOfDataRow += fieldsName.size()) {
                Row dataRow = sheet.createRow((indexOfDataRow / fieldsName.size()) + 1);
                List<String> rowValues = fieldsValue.subList(indexOfDataRow, indexOfDataRow + fieldsName.size());
                for (int indexOfValue = 0; indexOfValue < rowValues.size(); indexOfValue++) {
                    Cell cell = dataRow.createCell(indexOfValue);
                    cell.setCellValue(rowValues.get(indexOfValue));
                }
            }

            OutputStream fileOutput = Files.newOutputStream(new File(path).toPath());
            workbook.write(fileOutput);
        }
    }
}