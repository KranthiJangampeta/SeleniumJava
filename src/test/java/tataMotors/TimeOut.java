package tataMotors;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeOut {
    @Test(timeOut = 10000)
    public void test1() throws InterruptedException {
        Thread.sleep(9000);
        Assert.fail();
    }
}
