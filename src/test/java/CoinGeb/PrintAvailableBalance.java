package CoinGeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.annotations.Test;

import java.util.List;

public class PrintAvailableBalance {

    WebDriver driver;

    @Test(priority = 1)
    void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    void OpenLoginUrl() throws InterruptedException {
        driver.get("https://exchange.stage-coingeb.com/login");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void enterEmailPass() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shiva.mahajan@antiersolutions.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@123");
        Thread.sleep(15000);
        driver.findElement(By.xpath("//button[text()='Log In']")).click();
    }

    @Test(priority = 4)
    void navigateToBalance() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().to("https://exchange.stage-coingeb.com/balance");
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    void GetBalance() {

        List<WebElement> aa = (List<WebElement>) driver.findElements(By.cssSelector("tbody>tr"));
        WebElement bb = driver.findElement(By.xpath("//table[@class='ui celled sortable table']/tbody/tr"));
        int as = aa.size();
        for (int i = 1; i <= as; i++) {
            WebElement coin = driver.findElement(By.cssSelector("tbody>tr:nth-child(" + i + ")>td:nth-child(1)>div"));
            String a = coin.getText();
            WebElement element = driver.findElement(By.cssSelector("tbody>tr:nth-child(" + i + ")>td:nth-child(4)"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            WebElement balance = driver.findElement(By.cssSelector("tbody>tr:nth-child(" + i + ")>td:nth-child(4)>span"));
            String c = balance.getText();
            double b;
            b = Double.parseDouble(c);
            if (b > 0) {
                System.out.println("For " + a + " your balance  is " + b);
            }
            if (i == as / 2) {
                //Scrolling inside the table
                WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(bb);
                new Actions(driver)
                        .scrollFromOrigin(scrollOrigin, 0, 200)
                        .perform();
            }
        }
    }
}


