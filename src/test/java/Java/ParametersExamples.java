package Java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExamples {

    @Test
    @Parameters({"username","password"})
    public void Demo(String username,String password) throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(3000);

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        Thread.sleep(3000);
        String errormessage=driver.findElement(By.xpath("//div[text()='Invalid username or password']")).getText();

        Assert.assertEquals(errormessage,"Invalid username or password","Error message not matched with Actual Message");

    }
    @Test
    @Parameters({"username","password"})
    public  void testmethod(String username,String password)
    {
        System.out.println(username);
        System.out.println(password);
    }
}
