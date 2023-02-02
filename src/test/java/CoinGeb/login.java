package CoinGeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class login {
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
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shiva.mahajan+1@antiersolutions.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@123");
        Thread.sleep(1000);
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".rc-anchor-center-container>div")).click();
        driver.switchTo().parentFrame();        //driver.switchTo().defaultContent();
        Thread.sleep(15000);
        driver.findElement(By.cssSelector(".ui.primary.button.loginUIButton")).click();
        Thread.sleep(3000);
//
//        String otpKeyStr = "R4ZCLANOUMLKNYPYNLPPTK6OJD472BGI"; // <- this 2FA secret key.
//        Totp totp = new Totp(otpKeyStr);
//        String twoFactorCode = totp.now();
//
//
//        driver.findElement(By.xpath("//input[@placeholder='2FA Code']")).sendKeys(twoFactorCode);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='ui primary button loginUIButton']")).click();

        driver.findElement(By.xpath("//img[@class='copyModal']")).click();
        // Line of code to get text from the clipBoard and Printing in the Console
        String text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        System.out.println("Printing the text from ClipBoard :: " + text);
        // Line of code to get text in the form of string and Printing in the console
        WebElement b = driver.findElement(By.xpath("//div[@class='copy_iconinValue']/p"));
        System.out.println("This is the text printed with getText :: " + b.getText());
    }

    @AfterClass(enabled = false)
    void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    void secondUser() throws InterruptedException {
//        Thread.sleep(2000);

        Thread.sleep(1000);
        driver.get("https://exchange.stage-coingeb.com/login");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shiva.mahajan+3@antiersolutions.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@123");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".ui.primary.button.loginUIButton")).click();

    }

    void logout() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().to("https://exchange.stage-coingeb.com/trading/sxpbtc");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='ui simple dropdown dropNav white user-info hideUpper']//i[@class='user icon']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='visible menu transition']//div[2]")).click();
        Thread.sleep(1000);
    }

}
