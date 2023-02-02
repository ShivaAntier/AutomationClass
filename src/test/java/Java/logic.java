package Java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class logic {
    @Test
    void Logic() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();
        boolean a = true;
        int j = 1;
        while(true){
            for (int i=1;i<8;i++){
                if(j>2){
                    a=false;
                }
        }
            Thread.sleep(1000);
        }
    }
}
