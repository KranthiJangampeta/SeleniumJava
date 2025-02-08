package ThisAndSuperKeywords;

import org.testng.annotations.BeforeMethod;

public class Parent {
    public void method(){
        System.out.println("I'm in Method 1");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I'll run before each method");
    }
}
