package CoinGeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class testing {
    WebDriver driver;

    @Test
    void test() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    void manual() {
        System.setProperty("webdriver.gecko.driver", "src/test/driver/geckodriver.exe");
        driver = new FirefoxDriver();

    }
}
