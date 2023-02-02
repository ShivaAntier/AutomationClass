package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssertion {
    @Test
    void firstMethid(){

            Assert.assertEquals("Test is fail ","Please Enter you email!","This test case is failed");
    }
}
