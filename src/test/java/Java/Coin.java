package Java;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Coin {
    WebDriver driver;

    @BeforeClass
    public void show() throws InterruptedException, IOException {
    FileInputStream fis = new FileInputStream("C:\\Users\\user.LAPTOP-0UHFE9FH\\IdeaProjects\\New\\src\\test\\java\\Java\\config.propeties");
    Properties pro = new Properties();
    pro.load(fis);
    String url = pro.getProperty("url");
    driver.get(url);
    driver.manage().window().maximize();
    Thread.sleep(2000);
    }


    // SIGN IN
    //Mail Field
    @Test
    void signin() throws InterruptedException, IOException, UnsupportedFlavorException {

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shiva.mahajan@antiersolutions.com");
        Thread.sleep(2000);


        //Password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@123");
        Thread.sleep(2000);


//        //Click On The Eye Button
//        driver.findElement(By.xpath("//img[@src='/static/media/eyeClose.b57161e6.svg']")).click();
//        Thread.sleep(2000);

        //Frame
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));

        //Click On The Captcha Button
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        Thread.sleep(10000);

        //Back Frame
        driver.switchTo().defaultContent();

        //Sign In
        driver.findElement(By.xpath("//button[@class='ui primary button loginUIButton']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//img[@class='copyModal']")).click();
        driver.findElement(By.xpath("//div[@class='copy_iconinValue']")).click();
        String text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        System.out.println("Printing text" + text);
        driver.findElement(By.xpath("//input[@placeholder='Code']")).sendKeys("text");
    }
}
