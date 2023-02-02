package CupChairs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;

public class CopyFromClipboard {
    WebDriver driver;

    @Test
    void openWeb() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test(priority = 1)
    void login() throws InterruptedException, IOException, UnsupportedFlavorException {
        driver.get("https://exchange.stage-coingeb.com/login");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shiva.mahajan@antiersolutions.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@123");
        Thread.sleep(15000);
        driver.findElement(By.cssSelector(".ui.primary.button.loginUIButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@class='copyModal']")).click();
        String text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

        System.out.println(text);
        String text1[] = text.split(", ");

    }

    @AfterClass(enabled = false)
    void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
