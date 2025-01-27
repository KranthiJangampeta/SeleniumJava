package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class EndToEndTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        //Selecting the Contry
        driver.findElement(By.id("autosuggest")).sendKeys("it");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("United States (USA)")) {
                option.click();
                break;
            }
        }

        Thread.sleep(2000);


        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value='HYD']")).click();

        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']/descendant::a[@value='MAA']")).click();

        Thread.sleep(2000);

        // select the checkbox
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        System.out.println("Family and Friends checkbox is selected");

        //Select the number of passengers
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for(int i=0; i<5; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String actualPassengerCount = driver.findElement(By.id("divpaxinfo")).getText();
        String expectedPassengerCount = "6 Adult";
        Assert.assertEquals(actualPassengerCount, expectedPassengerCount);
        System.out.println("Passenger count is as expected and value is:" + actualPassengerCount);

        WebElement staticDd = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        // Selct currency
        Select dropdown = new Select(staticDd);
        dropdown.selectByValue("USD");
        System.out.println("Currency selected is: "+dropdown.getFirstSelectedOption().getText());

        //Click on the Search button
        driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
    }
}
