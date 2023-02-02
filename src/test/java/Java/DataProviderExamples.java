package Java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExamples {

    @Test
    @DataProvider(name = "testdata")
    public Object[][] getdata() {
        Object[][] data = new Object[2][2];
        data[0][0] = "3@yopmail.com";
        data[0][1] = "password";
        data[1][0] = "4@yopmail.com";
        data[1][1] = "password";
        return data;
    }

    @Test
            (dataProvider = "testdata")

    public void loginExample(String username, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();


        String errormessage = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
        Assert.assertEquals(errormessage, "The email address you entered isn't connected to an account. Find your account and log in.", "The message is not matching with the actual message");
        Thread.sleep(2000);
        driver.quit();
    }
}
