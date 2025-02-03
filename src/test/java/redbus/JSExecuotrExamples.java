package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JSExecuotrExamples {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:/Kranthi/Selenium/SeleniumJava/src/main/java/resources" + File.separator + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver; // example: int a = (int) 2.0;
        js.executeScript("window.scrollBy(0,600)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=600");

        List<WebElement> amountListElements = driver.findElements(By.xpath("(//table[@id='product'])[2]//tr/td[4]"));
        int sum = 0;
        for(int i=0; i<amountListElements.size(); i++){
            String amount = amountListElements.get(i).getText();
                sum = sum + Integer.parseInt(amount);
        }
        System.out.println("Actual sum is: " + sum);
        String expectedAmount = driver.findElement(By.cssSelector(".totalAmount:nth-of-type(2)")).getText().split(": ")[1];
        Assert.assertEquals(sum, Integer.parseInt(expectedAmount));
        driver.close();
    }
}