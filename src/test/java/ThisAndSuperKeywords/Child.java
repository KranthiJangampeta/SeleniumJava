package ThisAndSuperKeywords;

import org.testng.annotations.Test;

public class Child extends Parent {
    @Test
    public void test1() {
        // regular kind of called methods with object
        Parent p = new Parent();
        p.method();
    }

    @Test
    public void test2() {
        method();
    }
    @Test
    public void test3() {
        int driver = 5;
        Utils ut = new Utils(driver);
        System.out.println("input is: " + ut.printData());
       // Page pt = new Page(5);
        System.out.println("input has two Digits: " + ut.isTwoDigitNumber());
    }
}
