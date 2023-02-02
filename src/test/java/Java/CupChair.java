package Java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CupChair {
    WebDriver driver = new ChromeDriver();

    @Test(priority = 0)
    public void Link() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.get("https://qa-stage.cupchairs.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
        @Test(priority = 1)
        public void LoginButton() throws InterruptedException {
            driver.findElement(By.xpath("//a[@class='headerLinks btn login nav-link']")).click();
            Thread.sleep(1000);
        }
        @Test(priority = 2)
                public void Login() throws InterruptedException {
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mohit.sharma+1@antiersolutions.com");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Admin@1234");
            Thread.sleep(1000);
        }
        @Test(priority = 3)
                public void ExploreButton() throws InterruptedException {
            driver.findElement(By.xpath("//span[@class='btnName']")).click();
            Thread.sleep(2000);
        }
            @Test(priority = 4)
            public void Img() throws InterruptedException {
            driver.findElement(By.xpath("//a[@class='headerLinks register btn photographer']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//li[@class='nav-item']")).click();
            Thread.sleep(1000);
        }
        @Test(priority = 5)
                public  void ScrollDown() throws InterruptedException {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
            Thread.sleep(1000);
            int count = 0;
            for (int i = 1; i < 10; i++) {
                try {
                    driver.findElement(By.xpath("(//div[@class='photoFooter'])[position()=15]/h6")).click();
                    break;
                } catch (Exception e) {
                    ((JavascriptExecutor) driver).executeScript("scrollBy(0,250)");
                    Thread.sleep(5000);
                    count++;
                    System.out.println(count);
                }
            }
            Thread.sleep(5000);
        }
        @Test(priority = 6)
                public void Profile() throws InterruptedException {
            driver.findElement(By.xpath("(//button[@class='dropdown-toggle btn btn-primary'])[position()=2]")).click();
            Thread.sleep(1000);
        }
        @Test(priority = 7)
                public void LogOut() throws InterruptedException {
            driver.findElement(By.xpath("(//a[@class='logoutbtn dropdown-item'])[position()=2]")).click();
            Thread.sleep(2000);
            driver.quit();
        }
    }
