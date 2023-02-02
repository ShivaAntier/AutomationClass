package CoinGeb;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NewExcelClass {
    @Test
    void getExceldata() throws IOException {
        File src = new File("C:\\Users\\user\\Desktop\\testing.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet sheet = xsf.getSheet("Sheet2");
        int row_Count = sheet.getPhysicalNumberOfRows();
        System.out.println(" This the the row count :: " + row_Count);
        XSSFRow row = sheet.getRow(0);
        int Col_Count = row.getPhysicalNumberOfCells();
        System.out.println("This is row first cells " + Col_Count);
        row = sheet.getRow(1);
        Col_Count = row.getPhysicalNumberOfCells();
        System.out.println("This is row Second cells " + Col_Count);
        String data;
        for (int i = 0; i <= Col_Count; i++) {
            data = sheet.getRow(0).getCell(i).getStringCellValue();
            System.out.println("This is data in row 0 and cell 1 :: " + data);
        }
    }
}
