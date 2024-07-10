package util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XLUtils {

    public static void main(String[] args) throws IOException {
        File file = new File("Logindata.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        //System.out.println(rowCount);
        int cellCount = sheet.getRow(1).getLastCellNum();
        //System.out.println(cellCount);

        for (int i = 1; i <= rowCount; i++) {
            XSSFRow currentRow = sheet.getRow(i);
            for (int j = 0; j < cellCount; j++) {
                XSSFCell cell = currentRow.getCell(j);
                System.out.print(cell.toString()+"\t");

            }
            System.out.println();
        }


    }


}
