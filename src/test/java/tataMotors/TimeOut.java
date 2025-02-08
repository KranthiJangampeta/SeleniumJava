package tataMotors;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TimeOut {
    @Test(timeOut = 10000)
    public void test1() throws InterruptedException {
        Thread.sleep(9000);
        Assert.fail();
    }

    @Test(dataProvider = "getData")
    public void test2(String username, String password) {
        System.out.println(username+ " / " +password);
        System.out.println("I'm at test 2");
    }
    @DataProvider
    public Object[][] getData() {
        Object[][] userDetails = new Object[3][2];

        userDetails[0][0] = "user1";
        userDetails[0][1] = "password1";

        userDetails[1][0] = "user2";
        userDetails[1][1] = "password2";

        userDetails[2][0] = "user3";
        userDetails[2][1] = "password3";

        return userDetails;
    }
}