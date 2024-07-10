package util;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class XL {

        public Workbook getWorkbook(String filePath) throws IOException {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            return workbook;
        }

        private Sheet getSheetByName(String filePath, String sheetName) throws IOException {
            Sheet sheet = getWorkbook(filePath).getSheet(sheetName);
            return sheet;
        }

        private Sheet getSheetByIndex(String filePath, int sheetNumber) throws IOException {
            Sheet sheet = getWorkbook(filePath).getSheetAt(sheetNumber);
            return sheet;
        }

        public void  dataReadTest(String filePath, int sheetNumber) throws Exception {
            Sheet sheet = getSheetByIndex(filePath, sheetNumber);
            int rowCount = sheet.getLastRowNum();
            //System.out.println(rowCount);
            int cellCount = sheet.getRow(1).getLastCellNum();
            //System.out.println(cellCount);

            for (int i = 1; i <= rowCount; i++) {
                XSSFRow currentRow = (XSSFRow) sheet.getRow(i);
                for (int j = 0; j < cellCount; j++) {
                    XSSFCell cell = currentRow.getCell(j);
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

        }
    }


