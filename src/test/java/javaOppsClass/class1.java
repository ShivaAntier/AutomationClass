package javaOppsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class class1 {
    public class Upload_File {
        WebDriver driver;
        Properties p = new Properties();
        Properties loc = new Properties();
        FileReader fr1;
        FileReader fr2;


        public void setup() throws IOException, InterruptedException {


            if (driver == null) {
                System.out.println("The Path is:" + System.getProperty("user.dir"));
                fr1 = new FileReader(System.getProperty("user.dir") + "/src/resource.properties");
                p.load(fr1);
            }


            if (p.getProperty("browser").equals("chrome")) {
                System.out.println("chrome launch successfully");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(p.getProperty("testurl"));
            } else if (p.getProperty("browser").equals("firefox")) {
                System.out.println("firefox launch successfully");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(p.getProperty("testurl"));
            }
        }

        @Test
        public void Upload_File() throws InterruptedException, AWTException {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.findElement(By.xpath("/html/body/div[3]/iframe")).click();
            Thread.sleep(2000);

            driver.switchTo().frame(1);

            driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[2]/button")).click();
            Thread.sleep(5000);

            // scroll to reach upload button
//            JavascriptExecutor j = (JavascriptExecutor) driver;
//        j.executeScript("scroll(0,500)");
            // file path passed as parameter to StringSelection
            StringSelection s = new StringSelection("/home/user/Downloads/download.jpeg");
            // Clipboard copy
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
            System.out.println("success");
            //identify element and click

            Robot r = new Robot();
            //pressing enter
            r.keyPress(KeyEvent.VK_ENTER);
            //releasing enter
            r.keyRelease(KeyEvent.VK_ENTER);
            //pressing ctrl+v
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            //releasing ctrl+v
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);
            //pressing enter
            r.keyPress(KeyEvent.VK_ENTER);
            //releasing enter
            r.keyRelease(KeyEvent.VK_ENTER);
        }
    }

}

/* for(int i =1 ; i<=6;i++){
 * if (i<5){
 *
 * }
 *
 *
 * }*/
