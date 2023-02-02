package comm;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SignUp extends BaseClass {
    @Test(priority = 1, enabled = true)
    void openUrl() throws InterruptedException {
        super.openBrowser();
        driver.get("https://qa.jetnft.in/");
        //Sign-Up Button
        driver.findElement(By.xpath("//button[@class='button-style ms-2 ms-md-4']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 2, enabled = true)
    void checkEmailValidation() throws InterruptedException {
        String a = "Please enter valid email address";
        driver.findElement(By.xpath("//input[@placeholder='Please enter your Email']")).sendKeys("thekf");
        driver.findElement(By.xpath("//input[@name='fullname']")).click();
        Thread.sleep(1000);

        try {
            String b = driver.findElement(By.xpath("//small[text()='Please enter valid email address']")).getText();
            if (b.equals(a))
            {
                Assert.assertTrue(true, "It is working fine");
            } else
            {
                Assert.assertTrue(false, "It is not showing validation message or validation message isn't correct");
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
            Assert.assertTrue(false, "Something went wrong please check the code line 24 to 39");
        }
        Thread.sleep(1000);
    }
    @Test(priority = 3, enabled = true)
    void checkFullNameValidation() throws InterruptedException {
        String a = "Too Short!";
        //Full Name Field
        driver.findElement(By.name("fullname")).sendKeys("a");
        Thread.sleep(2000);
        //Username Field
        driver.findElement(By.xpath("//input[@name='username']")).click();
        Thread.sleep(1000);

        try {
            String b = driver.findElement(By.xpath("(//small[text()='Too Short!'])[1]")).getText();
            if (b.equals(a)) {
                Assert.assertTrue(true, "This is working fine");
            } else {
                Assert.assertTrue(false, "It is not showing validation message of validation message isn't correct");
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
            Assert.assertTrue(false, "Something went wrong please check the code line 52 to 65");
        }
        Thread.sleep(1000);
    }
    @Test(priority = 4, enabled = true)
    void checkUserNameValidation() throws InterruptedException {
        String a = "Too Short!";
        //Username Field
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("k");
        Thread.sleep(1000);
        //Password Field
        driver.findElement(By.xpath("//input[@name='password']")).click();
        Thread.sleep(1000);

        try {
            String b = driver.findElement(By.xpath("(//small[text()='Too Short!'])[2]")).getText();
            if (b.equals(a)) {
                Assert.assertTrue(true, "This is working fine");
            } else {
                Assert.assertTrue(false, "It is not showing validation message or validation message isn't correct");
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
            Assert.assertTrue(false, "Something went wrong please check the code line 78 to 91");
        }
        Thread.sleep(1000);
        }
        @AfterClass(enabled = false)
        @Test(priority = 5)
    void quitDriver() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
