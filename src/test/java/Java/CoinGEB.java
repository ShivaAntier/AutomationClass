package Java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CoinGEB {
    WebDriver driver = new ChromeDriver();
    @Test
    public void Link() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("https://exchange.stage-coingeb.com/");
        Thread.sleep(1000);
        //Click on the Login button
        driver.findElement(By.xpath("(//a[text()='Log In'])[1]")).click();
        Thread.sleep(1000);


        File file = new File("C:\\Users\\user.LAPTOP-0UHFE9FH\\OneDrive\\Documents\\CoinBGB.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("CoinGEB");

        String username = (sheet.getRow(0).getCell(0).getStringCellValue());
        //Email Field
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(username);
        Thread.sleep(1000);

        String password = (sheet.getRow(0).getCell(1).getStringCellValue());
        //Password Field
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        Thread.sleep(1000);

        //I-frame
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        Thread.sleep(1000);

        //Click on the Captcha button
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        Thread.sleep(1000);

        //Back frame
        driver.switchTo().defaultContent();
        Thread.sleep(10000);

        //Click on the Login button
        driver.findElement(By.xpath("//button[text()='Log In']")).click();
        Thread.sleep(1000);

        //Click on the Close button
        driver.findElement(By.xpath("//button[@class='ui button resetButton grayBtn']")).click();
        Thread.sleep(1000);

        //Click on the Exchange button
        driver.findElement(By.xpath("//ul[@class='navigationLink']/li[5]")).click();
        Thread.sleep(1000);

        //Scroll
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)","");
        Thread.sleep(1000);

        File file1 = new File("C:\\Users\\user.LAPTOP-0UHFE9FH\\OneDrive\\Documents\\CoinBGB.xlsx");
        FileInputStream fis1 = new FileInputStream(file1);
        XSSFWorkbook workbook1 = new XSSFWorkbook(fis1);
        XSSFSheet sheet1 = workbook1.getSheet("CoinGEB");

        double value = sheet1.getRow(1).getCell(0).getNumericCellValue();
        String val = String.valueOf(value);
        driver.findElement(By.xpath("//input[@name='price']")).sendKeys(val);
        Thread.sleep(1000);

        double amount = sheet1.getRow(1).getCell(1).getNumericCellValue();
        String amu = String.valueOf(amount);
        driver.findElement(By.xpath("//input[@name='buy_amount']")).sendKeys(amu);
    }
}
