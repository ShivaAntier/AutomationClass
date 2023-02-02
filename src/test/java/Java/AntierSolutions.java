package Java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AntierSolutions {
    WebDriver driver = new ChromeDriver();
    @Test
    public void Antier() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("https://www.antiersolutions.com/");
        Thread.sleep(1000);

        //Click On The Contact Us Button
        driver.findElement(By.xpath("//span[text()='CONTACT US']")).click();
        Thread.sleep(1000);

        //Your Name
        driver.findElement(By.xpath("//input[@name='your-name']")).sendKeys("Naveen");
        Thread.sleep(1000);

        //Email
        driver.findElement(By.xpath("//input[@name='email-708']")).sendKeys("naveen@gmail.com");
        Thread.sleep(1000);

        //Country
        driver.findElement(By.xpath("(//div[@class='selected-flag'])[1]")).click();
        driver.findElement(By.xpath("(//span[@class='country-name'])[1]")).click();

        //Phone Number
        driver.findElement(By.xpath("(//input[@name='tel-147'])[1]")).sendKeys("1234567891");

        //Message
        driver.findElement(By.xpath("//textarea[@name='your-message']")).sendKeys("I have read the terms and conditions");

    }
}
