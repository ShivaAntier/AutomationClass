package shido;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    WebDriver driver;
    void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}
