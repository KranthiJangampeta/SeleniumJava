package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Second {

    @Test
    public void testMethod() {
        System.out.println("This is a test method one");
    }
    @Test
    public void testMethod2(){
        System.out.println("This is a test method two");
    }
    @Test
    public void testMethod3(){
        Assert.fail();
        System.out.println("This is a test method three");
    }
}
