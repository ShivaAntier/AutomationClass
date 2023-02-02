package Java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookExamples {
    WebDriver driver = new ChromeDriver();


//    @Test
//     void SignUp() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//
//        //Create New Account Button
//        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
//        Thread.sleep(2000);
//
//        //First Name
//        driver.findElement(By.name("firstname")).sendKeys("Virat");
//        Thread.sleep(1000);
//
//        //Surname
//        driver.findElement(By.name("lastname")).sendKeys("Singh");
//        Thread.sleep(1000);
//
//        //Mobile Number Or Email Address
//        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("username12@yopmail.com");
//        Thread.sleep(1000);
//
//        //Re-Enter Email Address
//        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("username12@yopmail.com");
//
//        //New Password
//        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Admin@123");
//
//        //DOB
//        Select sel = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
//        sel.selectByValue("20");
//        Thread.sleep(1000);
//        Select st = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
//        st.selectByValue("10");
//        Thread.sleep(1000);
//        Select str= new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
//        str.selectByValue("2002");
//        Thread.sleep(1000);
//        //OTP
//        driver.findElement(By.xpath("//input[@id='jsc_c_5']")).sendKeys("a");
//        Thread.sleep(1000);
//
//    }

    @Test
    void SignIn() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //Email
        driver.findElement(By.id("email")).sendKeys("8529929504");
        Thread.sleep(1000);

        //Password
        driver.findElement(By.id("pass")).sendKeys("Ronny1238");
        Thread.sleep(1000);

        //Click On The Eye Button
        driver.findElement(By.xpath("//div[@class='_9lsb _9ls8']")).click();
        Thread.sleep(1000);

        //Login Button
        driver.findElement(By.name("login")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='x1l7q5kx x1ey2m1c x9f619 xds687c x10l6tqk x17qophe x13vifvy']")).click();
        Thread.sleep(1000);

        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();
        Thread.sleep(1000
        );

        driver.findElement(By.xpath("//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6'][1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft']")).click();
        Thread.sleep(1000);

    }
}
