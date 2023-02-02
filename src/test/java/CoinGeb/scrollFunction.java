package CoinGeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;


public class scrollFunction {
    WebDriver driver;

    @Test
    public void AOpenUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void shouldScrollToElement() {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        new Actions(driver)
                .scrollToElement(iframe)
                .perform();
        Assertions.assertTrue(inViewport(iframe));
    }

    @Test(enabled = false)
    public void shouldScrollFromViewportByGivenAmount() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        Thread.sleep(3000);

        WebElement footer = driver.findElement(By.tagName("footer"));
        int deltaY = footer.getRect().y;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();

        Assertions.assertTrue(inViewport(footer));
    }

    @Test(enabled = false)
    public void shouldScrollFromElementByGivenAmount() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        Thread.sleep(5000);

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(iframe);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();

        driver.switchTo().frame(iframe);
        WebElement checkbox = driver.findElement(By.name("scroll_checkbox"));
//        Assertions.assertTrue(inViewport(checkbox));
        Thread.sleep(5000);
    }

    @Test(enabled = false)
    public void shouldScrollFromElementByGivenAmountWithOffset() {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");

        WebElement footer = driver.findElement(By.tagName("footer"));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(footer, 0, -50);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement checkbox = driver.findElement(By.name("scroll_checkbox"));
        Assertions.assertTrue(inViewport(checkbox));
    }

    @Test(enabled = false)
    public void shouldScrollFromViewportByGivenAmountFromOrigin() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame.html");

        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement checkbox = driver.findElement(By.name("scroll_checkbox"));
        Assertions.assertTrue(inViewport(checkbox));
    }

    private boolean inViewport(WebElement element) {

        String script =
                "for(var e=arguments[0],f=e.offsetTop,t=e.offsetLeft,o=e.offsetWidth,n=e.offsetHeight;\n"
                        + "e.offsetParent;)f+=(e=e.offsetParent).offsetTop,t+=e.offsetLeft;\n"
                        + "return f<window.pageYOffset+window.innerHeight&&t<window.pageXOffset+window.innerWidth&&f+n>\n"
                        + "window.pageYOffset&&t+o>window.pageXOffset";

        return (boolean) ((JavascriptExecutor) driver).executeScript(script, element);
    }
}

