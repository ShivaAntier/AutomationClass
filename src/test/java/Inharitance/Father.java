package Inharitance;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Father {
    WebDriver driver;

    @Test(priority = 1)
    void test() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("This is Father Class!");
    }
}
