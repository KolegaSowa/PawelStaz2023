package org.example.using.reader;

import org.apache.poi.ss.usermodel.*;
import org.example.interfaces.DocumentFileReader;

import java.io.FileInputStream;
import java.io.IOException;

public class XlsxReader implements DocumentFileReader {

    @Override
    public void readFile(String path) throws IOException {
        Workbook workbook;

        FileInputStream fins = new FileInputStream(path);
        workbook = WorkbookFactory.create(fins);
        Sheet sheet = workbook.getSheetAt(0);
        FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

        for (Row row : sheet){
            for(Cell cell : row){
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()){
                    case NUMERIC -> System.out.println(cell.getNumericCellValue());
                    case STRING -> System.out.println(cell.getStringCellValue());
                }
            }
        }
    }
}
