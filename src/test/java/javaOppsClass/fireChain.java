package javaOppsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class fireChain {
    WebDriver driver;
    String Memo = "always layer water mean mail patrol absurd axis bubble summer smooth twist";

    @Test
    void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://qa-web-exp.5ire.network/wallet");
        Thread.sleep(6000);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@placeholder=\"Enter your mnemonics\"]")).sendKeys(Memo);
        driver.findElement(By.xpath("//div[text()=\"Login\"]")).click();
        Thread.sleep(3000);
        WebElement Address = driver.findElement(By.xpath("//input[@placeholder='Please enter recepients address']"));
        WebElement Amount = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));


        for (int i = 1; i <= 2; i++) {
            Thread.sleep(3000);
            Address.sendKeys("5E6LfPy5ukR1AqD52ZRvXaQCbz4zLHEr4BLJEVKRPfjDRWtW");
            Amount.sendKeys("1");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@id='transfer']")).click();
            Thread.sleep(2000);
            Address.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            Amount.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        }
    }
}
