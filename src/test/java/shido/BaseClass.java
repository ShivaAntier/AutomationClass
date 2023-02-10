package shido;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class BaseClass {

    public static WebDriver driver;
    String a;
    String b;

    void OpenBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://qa.jetnft.in/login");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://qa.jetnft.in/login");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://qa.jetnft.in/login");

    }

    void driverGet() throws InterruptedException {
        ArrayList<String> arr = new ArrayList(driver.getWindowHandles());
        System.out.println("this is arr ::"+arr);
        for (int i = 0 ; i <arr.size();i++){
            driver.switchTo().window(arr.get(i));
//            if (a.equals(b)){
//                break;
//            }
            Thread.sleep(2000);
        }
    }

    @AfterClass(enabled = false)
    void quitDriver() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}
