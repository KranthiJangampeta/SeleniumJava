package tataMotors;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ServicingTeam {
    //String url = "https://www.tatamotorCars.com/";
    @Test(groups = {"Smoke"})
    public void serviceHarrierModel() {
        System.out.println("Servicing - Harrier is serviced");
    }

    @Parameters({"URL", "UserName", "Password"})
    @Test
    public void serviceNanoModel(String tataMotorsUrl, String username, String password) {
        System.out.println(tataMotorsUrl);
        System.out.println(username+" / "+ password);
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
