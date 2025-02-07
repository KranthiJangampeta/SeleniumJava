package tataMotors;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ServicingTeam {

    @Test(groups = {"Smoke"})
    public void serviceHarrierModel() {
        System.out.println("Servicing - Harrier is serviced");
    }

    @Test
    public void serviceNanoModel() {
        System.out.println("Servicing - Nano is serviced");
    }

    @Test
    public void servicePunchModel() {
        System.out.println("Servicing - Punch is serviced");
    }

    @Test
    public void serviceNexonModel() {
        System.out.println("Servicing - Nexon is serviced");
    }

    @BeforeTest
    public void amBeforeTest() {
        System.out.println("````Servicing Team - Before Test````");
    }

    @AfterTest
    public void amAfterTest() {
        System.out.println("````Servicing Team - After Test````");
    }

}
