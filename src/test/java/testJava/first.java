package testJava;

import org.testng.annotations.Test;

public class first {
    int a = 1;
@Test
    void test3(){
        this.test();
        this.test2();
    }
    void test() {
        a = 20;
        System.out.println(a);
    }

    void test2() {

        System.out.println(a);
    }
}
