package shido;

import org.testng.annotations.Test;

public class login {
    @Test
    void testthisClass() throws InterruptedException {
        BaseClass bc = new BaseClass();
        bc.OpenBrowser();
        bc.driverGet();
        functions fc = new functions();
        fc.testAarray();
    }
}
