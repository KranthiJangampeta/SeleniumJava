package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionsClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.get("https://www.flipkart.com/");
        WebElement loginButton = driver.findElement(By.xpath("//a[@title='Login' and @aria-haspopup='true']"));
        //className objName = new className();
        Actions a = new Actions(driver);
        //a.moveToElement(loginButton).build().perform(); // write build & perform at the end for all the actions
        a.moveToElement(loginButton).contextClick().build().perform();
        WebElement searchBar = driver.findElement(By.xpath("//input[contains(@title,'Search for Products')]"));
        a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("mobile").doubleClick().build().perform();
        driver.quit();
    }
}
