package tataMotors;

import org.testng.annotations.Test;

public class ClassAdmin {
    @Test(groups = {"Smoke"}, enabled = false)
    public void adminMethod1() {
        System.out.println("Admin Method 1");
    }
}
