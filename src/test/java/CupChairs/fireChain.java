package CupChairs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class fireChain {

    WebDriver driver;

    @Test(priority = 1)
    void open() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://explorer.5ire.network/");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    void sendMsg() throws InterruptedException {
        driver.findElement(By.xpath("//iframe[@title=\"Button to launch messaging window\"]")).click();
        Thread.sleep(2000);
        WebElement a = driver.findElement(By.xpath("//iframe[@title='Messaging window']"));
        driver.switchTo().frame(a);
        Thread.sleep(6000);
        driver.findElement(By.xpath("//button[text()='Technical Help']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@placeholder=\"Type a message\"]")).sendKeys("hi this is shiva!");
    }
}
