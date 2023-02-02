package Java.Excel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Data {
    WebDriver driver;

    @Test
    public void Login() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        File file = new File("C:\\Users\\user.LAPTOP-0UHFE9FH\\OneDrive\\Documents\\Sheet1.xlsx");


        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int row = sheet.getPhysicalNumberOfRows();
        System.out.println("This is No of rows :: " + row);

        Row rw = sheet.getRow(0);
        Cell cell = rw.getCell(0);
        System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());

        Row rw2 = sheet.getRow(1);
        Cell cell2 = rw2.getCell(0);
        System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());

        String username = (sheet.getRow(0).getCell(0).getStringCellValue());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
        Thread.sleep(1000);
        String password = (sheet.getRow(0).getCell(1).getStringCellValue());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
        Thread.sleep(5000);
        driver.quit();
    }
}
