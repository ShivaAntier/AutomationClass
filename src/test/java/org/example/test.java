package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class test {

    @Test
    void robotCLass() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_A);
    }

    @Test(enabled = false)
    void testing() throws AWTException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(""));
        WebDriver driver = new ChromeDriver(options);

    }

    @Test(enabled = false)
    void testingg() {
        String otpKeyStr = "R4ZCLANOUMLKNYPYNLPPTK6OJD472BGI"; // <- this 2FA secret key.
        Totp totp = new Totp(otpKeyStr);
        String twoFactorCode = totp.now();
        System.out.println("This is the current Otp :: " + twoFactorCode);

        boolean second = totp.verify(String.valueOf(twoFactorCode));
        System.out.println("this is second :: " + second);
    }


}


//public class Upload_File extends Base {
//
//    @Test
//    public void Upload_File() throws InterruptedException, AWTException {
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//
//        driver.findElement(By.xpath("/html/body/div[3]/iframe")).click();
//        Thread.sleep(2000);
//
//        driver.switchTo().frame(1);
//
//        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[2]/button")).click();
//        Thread.sleep(5000);
//
//        // scroll to reach upload button
//        JavascriptExecutor j = (JavascriptExecutor)driver;
////        j.executeScript("scroll(0,500)");
//        // file path passed as parameter to StringSelection
//        StringSelection s = new StringSelection("/home/user/Downloads/download.jpeg");
//        // Clipboard copy
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
//        System.out.println("success");
//        //identify element and click
//
//        Robot r = new Robot();
//        //pressing enter
//        r.keyPress(KeyEvent.VK_ENTER);
//        //releasing enter
//        r.keyRelease(KeyEvent.VK_ENTER);
//        //pressing ctrl+v
//        r.keyPress(KeyEvent.VK_CONTROL);
//        r.keyPress(KeyEvent.VK_V);
//        //releasing ctrl+v
//        r.keyRelease(KeyEvent.VK_CONTROL);
//        r.keyRelease(KeyEvent.VK_V);
//        //pressing enter
//        r.keyPress(KeyEvent.VK_ENTER);
//        //releasing enter
//        r.keyRelease(KeyEvent.VK_ENTER);
//    }


//
// driver.switchTo().newWindow(WindowType.TAB);
//         Thread.sleep(3000);
//
//   driver.switchTo().newWindow(WindowType.WINDOW);