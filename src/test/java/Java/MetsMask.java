package Java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class MetsMask {
    public static void main(String[] args) throws InterruptedException, IOException, UnsupportedFlavorException {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
     //MetsMask
     options.addExtensions(new File("\\Users\\user.LAPTOP-0UHFE9FH\\Downloads\\MetaMask.crx"));
     WebDriver driver = new ChromeDriver(options);
     driver.manage().window().maximize();

     //Set
     Set<String> wd = driver.getWindowHandles();
     Iterator<String> it = wd.iterator();
     Thread.sleep(1000);

     //Switch
     driver.switchTo().window(it.next());
     Thread.sleep(2000);

     //Click On The Get Started Button
     driver.findElement(By.xpath("//button[@class='button btn--rounded btn-primary first-time-flow__button']")).click();
     Thread.sleep(1000);

     //Click On The Agree Button
     driver.findElement(By.xpath("//button[@class='button btn--rounded btn-primary page-container__footer-button']")).click();
     Thread.sleep(1000);

     //Click On The Create A Wallet Button
     driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
     Thread.sleep(1000);

     //Password Field
     driver.findElement(By.id("create-password")).sendKeys("Admin@123");
     Thread.sleep(1000);

     //Confirm Password Field
     driver.findElement(By.id("confirm-password")).sendKeys("Admin@123");
     Thread.sleep(1000);

     //Click On The Box Button
     driver.findElement(By.xpath("//span[text()='I have read and agree to the ']")).click();
     Thread.sleep(1000);

     //Click On The Create Button
     driver.findElement(By.xpath("//button[text()='Create']")).click();
     Thread.sleep(2000);

     //Click On The Next Button
     driver.findElement(By.xpath("//button[@class='button btn--rounded btn-primary']")).click();
     Thread.sleep(1000);

     //Clcik On The Click Here To Reveal Secret Words Button
     driver.findElement(By.xpath("//div[@class='reveal-seed-phrase__secret-blocker']")).click();
     Thread.sleep(1000);

     //Get Text
     String text = driver.findElement(By.xpath("//div[@class=\"reveal-seed-phrase__secret-words notranslate\"]")).getText();
     Thread.sleep(1000);

     //Click On The Next Button
     driver.findElement(By.xpath("//button[text()='Next']")).click();
     Thread.sleep(1000);

     //Split
     String [] st = text.split(" ");
     System.out.println(st.length);
     for(int i=0; i<st.length; i++)
     {
      System.out.println(st[i]);
      driver.findElement(By.xpath("//div[@class='btn-secondary notranslate confirm-seed-phrase__seed-word confirm-seed-phrase__seed-word--sorted'and contains(text(),'"+st[i]+"')]")).click();
     }
     Thread.sleep(1000);
     driver.findElement(By.xpath("//button[@class='button btn--rounded btn-primary first-time-flow__button']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//button[text()='All done']")).click();
     Thread.sleep(1000);
     driver.quit();
    }
}
