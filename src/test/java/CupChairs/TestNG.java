package CupChairs;

import org.testng.annotations.Test;

public class TestNG {
    @Test(priority = 0)
    void test() {
        System.out.println("Helllo test !!!");
    }

    @Test(priority = -1)
    public void thisid() {
        System.out.println("hello world !!");
    }
}
