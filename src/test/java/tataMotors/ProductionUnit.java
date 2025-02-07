package tataMotors;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ProductionUnit {
    @Test(groups = {"Smoke"})
    public void produceHarrierModel() {
        System.out.println("Production - Harrier is made");
    }
    @Test
    public void produceNanoModel() {
        System.out.println("Production - Nano is made");
    }
    @Test
    public void producePunchModel() {
        System.out.println("Production - Punch is made");
    }
    @Test
    public void produceNexonModel() {
        System.out.println("Production - Nexon is made");
    }

    @AfterSuite
    public void clearCookies(){
        System.out.println("````Cleared Cookies````");
    }
    @BeforeSuite
    public void launchChromeBrowser(){
        System.out.println("````Launched Chrome Browser````");
        System.out.println("``Maximized Browser Window``");
    }
}
