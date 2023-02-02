package Java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class ScreenShot {
    WebDriver driver = new ChromeDriver();
    @Test
    public void TakeScreenShot(Method method) throws InterruptedException, IOException {
        String FileWithPath = "C:\\Users\\user.LAPTOP-0UHFE9FH\\OneDrive\\Pictures\\Screenshots\\N\\"+method.getName()+".png";
        WebDriverManager.chromedriver().setup();
        driver.get("https://stage.jetnft.in/");
        driver.manage().window().maximize();
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File files = screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File(FileWithPath);
        FileUtils.copyFile(files,file);
        Thread.sleep(5000);
        driver.quit();
    }
}
