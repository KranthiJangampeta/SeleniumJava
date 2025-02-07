package tataMotors;

import org.testng.annotations.Test;

public class SalesTeam {
    @Test(groups = {"Smoke"},priority = 1)
    public void sellHarrierModel() {
        System.out.println("Sales - Harrier is sold");
    }
    @Test(priority = 2)
    public void sellNanoModel() {
        System.out.println("Sales - Nano is sold");
    }
    @Test(priority = 3)
    public void sellPunchModel() {
        System.out.println("Sales - Punch is sold");
    }
    @Test(dependsOnMethods = {"sellPunchModel"},priority = 4)
    public void sellNexonModel() {
        System.out.println("Sales - Nexon is sold");
    }
}
