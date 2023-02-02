package CoinGeb;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FatchExceldata {
    public static void main(String[] args) throws IOException {
        File src = new File("C:\\Users\\user\\Desktop\\test.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet sheet = xsf.getSheet("Sheet1");
        String data;
        double intData;
        int row_count = sheet.getPhysicalNumberOfRows();//counting number of rows
        XSSFRow row = sheet.getRow(0);
        int col_count = row.getPhysicalNumberOfCells();
        data = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println("This is value in row 0 and cell 0 ::" + data);
        data = sheet.getRow(0).getCell(1).getStringCellValue();
        System.out.println("This is value in row 0 and cell 1 ::" + data);
        intData = sheet.getRow(1).getCell(0).getNumericCellValue();
        System.out.println("This is value in row 1 and cell 0 ::" + intData);
        intData = sheet.getRow(1).getCell(1).getNumericCellValue();
        System.out.println("This is value in row 1 and cell 1 ::" + intData);
    }
}
