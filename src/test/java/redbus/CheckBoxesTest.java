package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxesTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        boolean checkboxStatus = driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).isSelected();
        System.out.println(checkboxStatus);
        driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
        checkboxStatus = driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).isSelected();
        System.out.println(checkboxStatus);

        boolean checkbox2Status = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected();
        Assert.assertFalse(checkbox2Status); // always expects false
       driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

       checkbox2Status = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected();
        Assert.assertTrue(checkbox2Status); // always expects true

        //Click on the Passengers dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        // select number 6 passengers
        for(int i=0; i<4; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        // click option done
        driver.findElement(By.id("btnclosepaxoption")).click();

        // get number of passengers selected
        String actualPassengerCount = driver.findElement(By.id("divpaxinfo")).getText();
        String expectedPassengerCount = "6 Adult";
        Assert.assertEquals(actualPassengerCount, expectedPassengerCount);
        driver.quit();



    }
}
