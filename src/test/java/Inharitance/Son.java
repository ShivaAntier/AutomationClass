package Inharitance;

import org.testng.annotations.Test;

public class Son extends Father {
    @Test(priority = 2)
    void test() {
        driver.get("https://www.google.co.in/");
        System.out.println("This is Son Class!");
    }
}
