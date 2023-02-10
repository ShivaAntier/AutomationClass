package shido;


import org.testng.annotations.Test;



public class functions extends BaseClass{
    @Test

    void testAarray() throws InterruptedException {
        BaseClass bc = new BaseClass();
        bc.OpenBrowser();
        bc.driverGet();
    }

    @Test(priority = 1)
    void navigateNew(){
        driver.get("https://github.com/appium/appium/issues/18152");
    }
}
