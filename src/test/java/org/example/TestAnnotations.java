package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class TestAnnotations {
    WebDriver driver;
    String countryName = "Canada";

    @Test
    void tesing() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa.lottdex.com/signup");
        Thread.sleep(2000);
        WebElement a = driver.findElement(By.xpath("//select[@name='country']"));
        Thread.sleep(500);
        Select select = new Select(a);
        select.selectByValue(countryName);
        Thread.sleep(2000);
        select.selectByIndex(2);
        Thread.sleep(2000);
        select.selectByVisibleText(countryName);
        Thread.sleep(2000);


//        driver.findElement(By.xpath("//input[@name='zipCode']")).click();


    }
}
