package tataMotors;

import org.testng.annotations.*;

public class MarketingTeam {
    @Test(groups = {"Smoke"})
    public void marketHarrierModel() {
        System.out.println("Marketing - Harrier is a great car");
    }
    @Test
    public void marketNanoModel() {
        System.out.println("Marketing - Nano is a Budget friendly car");
    }
    @Test
    public void marketPunchModel() {
        System.out.println("Marketing - Punch is a powerful car");
    }
    @Test
    public void marketNexonModel() {
        System.out.println("Marketing - Nexon is a popular car");
    }
    @BeforeMethod
    public void tataMotorsMarketingLogin(){
        System.out.println("````Logged in to Tata Motors Marketing Website````");
    }
    @AfterMethod
    public void tataMotorsMarketingAppLogout(){
        System.out.println("````Logged out of Tata Motors Marketing Website````");
    }
    @BeforeClass
    public void tataMotorsMarketingAppLaunch(){
        System.out.println("````Launched Tata Motors Marketing Website - www.tatamotors.com/marketing````");
    }

    @AfterClass
    public void tataMotorsMarketingAppClose(){
        System.out.println("````Closed Browser````");
    }

}
