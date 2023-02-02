package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class test2 {
    WebDriver driver;

    @Test(priority = -1)
    void Testing() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //This line of code is used to remove the alert i.e. "Chrome is being used by automation tool"
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://exchange.stage-coingeb.com/login");
        Thread.sleep(3000);
        List<WebElement> webElements = driver.findElements(By.xpath("//div[@class='ui left icon input']"));
        System.out.println("List of webElements :: " + webElements);
    }
}
