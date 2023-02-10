package shido;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SignUp extends BaseClass {
    @Test(priority = 1, enabled = true)
    void openUrl() {
//        super.OpenBrowser();
        driver.get("https://qa.jetnft.in/signup");
    }

    @Test(priority = 2, enabled = true)
    void CheckEmailValidator() throws InterruptedException {
        Thread.sleep(2000);
        String a = "Please enter valid email address";
        driver.findElement(By.xpath("//input[@placeholder='Please enter your Email']")).sendKeys("thekf");
        driver.findElement(By.xpath("//input[@name='fullname']")).click();
        Thread.sleep(1000);
        try {
            String b = driver.findElement(By.xpath("//small[text()='Please enter valid email address']")).getText();
            if (b.equals(a)) {
                Assert.assertTrue(true, "This is working fine !!");
            } else {
                Assert.assertTrue(false, "it is not showing any validation or validation massage is incorrect");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
            Assert.assertTrue(false, "Something went Wrong Please check Code line 21 to 28");
        }
    }

    @AfterClass(enabled = false)
    void QuitDriver() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}
