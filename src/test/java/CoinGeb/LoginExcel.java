package CoinGeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LoginExcel {
    File src;
    FileInputStream fis;
    XSSFWorkbook xsf;
    XSSFSheet sheet;
    int row_count;
    int col_count;
    XSSFRow row;
    String url = "https://exchange.stage-coingeb.com";
    WebDriver driver;

    public LoginExcel() throws IOException {
        src = new File("C:\\Users\\user\\Desktop\\test.xlsx");
        fis = new FileInputStream(src);
        xsf = new XSSFWorkbook(fis);
        sheet = xsf.getSheet("Sheet1");
        row_count = sheet.getPhysicalNumberOfRows();//counting number of rows
        row = sheet.getRow(0);
        col_count = row.getPhysicalNumberOfCells();//counting number of columns
    }

    @Test(priority = 0)
    public void OpenUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url + "/login");
    }

    @Test(priority = 1)
    public void read_data() throws InterruptedException {
        String entry = sheet.getRow(0).getCell(0).getStringCellValue();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(entry);
        entry = sheet.getRow(0).getCell(1).getStringCellValue();
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(entry);
        Thread.sleep(15000);
        driver.findElement(By.cssSelector(".ui.primary.button.loginUIButton")).click();
    }

    @Test(priority = 2)
    public void trading() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().to("https://exchange.stage-coingeb.com/trading/sxpbtc");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,150)");
        double intValue = sheet.getRow(1).getCell(0).getNumericCellValue();
        Thread.sleep(2000);
        String entry = String.valueOf(intValue);
        driver.findElement(By.xpath("//input[@placeholder='Price']")).sendKeys(entry);
        intValue = sheet.getRow(1).getCell(1).getNumericCellValue();
        entry = String.valueOf(intValue);
        driver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys(entry);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='ui button resetButton buyButton']")).click();


    }

}
