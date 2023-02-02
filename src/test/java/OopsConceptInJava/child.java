package OopsConceptInJava;

import org.testng.annotations.Test;

public class child extends parent {
    @Test
    void callParent() {
        super.first();
        System.out.println(i);
    }

    void first() {
        i = i + 20;
    }
}
