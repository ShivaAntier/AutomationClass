package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class test3 {
    WebDriver driver;
    String countryName = "Aland Islands";

    @Test
    void tesing() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa.lottdex.com/signup");
        Thread.sleep(2000);
        WebElement d = driver.findElement(By.cssSelector(".SelectField>select"));
//        d.click();
        Thread.sleep(2000);

//        for (int i = 1; i <= a.size(); i++) {
        Select select = new Select(d);

        select.selectByValue(countryName);
        Thread.sleep(2000);
        select.selectByIndex(5);
        select.deselectAll();
        Thread.sleep(2000);

        Thread.sleep(2000);
        select.selectByVisibleText(countryName);
//        WebElement b = driver.findElement(By.cssSelector(".SelectField>select>option:nth-child(" + i + ")"));
//        String c = b.getText();
//        System.out.println("Value of c : " + c);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(b).perform();
//        if (c.equals(countryName)) {


        }
    }
//        driver.findElement(By.xpath("//input[@name='zipCode']")).click();
//}


