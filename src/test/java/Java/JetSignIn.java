package Java;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class JetSignIn {
    WebDriver driver;

    public JetSignIn() throws IOException {
    }

    @Test(priority = 1, enabled = true)
    void openUrl(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://qa.jetnft.in/");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void clickOnSignInButton() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
    }
        File file = new File("C:\\Users\\user.LAPTOP-0UHFE9FH\\Downloads\\Jet.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Jet");

        @Test(priority = 3, enabled = true)
            void sendEmail() throws InterruptedException {
            Thread.sleep(2000);
            String Email = (sheet.getRow(2).getCell(0).getStringCellValue());
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Email);
        }

        @Test(priority = 4)
            void sendPassword() throws InterruptedException {
            Thread.sleep(2000);
            String Password = (sheet.getRow(2).getCell(1).getStringCellValue());
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
        }

        @Test(priority = 5, enabled = true)
            void clickOnEyeButton() throws InterruptedException {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='ShowHideIcon']")).click();
        }

        @Test(priority = 6, enabled = true)
            void clickOnSignInButtonAgain() throws InterruptedException {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        }
}
