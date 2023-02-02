package CupChairs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CupChairs {
    WebDriver driver;
    String name = "ballon";

    @Test(priority = 1)
    void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-stage.cupchairs.com");
    }

    @Test(priority = 2)
    void login() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='headerLinks btn login nav-link']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys("mohit.sharma+1@antiersolutions.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Admin@1234");
        driver.findElement(By.xpath("//span[@class='btnName']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='headerLinks register btn photographer']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@class='tabsWrap nav nav-tabs']/li[1]")).click();
        Thread.sleep(3000);

        int j = 1, k = 10;
        while (true) {
            for (int i = j; i <= k; i++) {
                WebElement b = driver.findElement(By.cssSelector(".tab-content>div:nth-child(1)>div>div>div>div>div:nth-child(" + i + ")>div>div:nth-child(3)"));
                String a = b.getText();
                b.getSize();
                //posts
                if (a.contains(name)) {
                    driver.findElement(By.cssSelector(".tab-content>div:nth-child(1)>div>div>div>div>div:nth-child(" + i + ")")).click();
                    break;
                }

            }
            j += 10;
            k += 10;
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
        }

    }
}
