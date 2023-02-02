package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    WebDriver driver;

    @Test(priority = -1)
    void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //This line of code is used to remove the alert i.e. "Chrome is being used by automation tool"
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addExtensions(new File("D:/drivers/MetaMask.crx"));
        options.addExtensions(new File("D:/drivers/SelectorsHub.crx"));
        driver = new ChromeDriver(options);
    }

    @Test(priority = 0)
    void OpenNewTab() throws InterruptedException {
        driver.close();
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#initialize/welcome");

//        Set<String> set = driver.getWindowHandles();
//        System.out.println("Value of set ::"+ set);
//
//        String currentWindow = driver.getWindowHandle();
//        Iterator<String> itr = set.iterator();
//        driver.switchTo().window(itr.next());
//        System.out.println("My current window :: "+ currentWindow);

//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//button[text()='Get started']")).click();


    }

}


