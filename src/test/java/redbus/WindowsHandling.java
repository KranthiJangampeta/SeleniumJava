package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsHandling {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.className("blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); // it returns all the opened windows in the form of Set of Strings
        Iterator<String> it = windows.iterator();
        String firstWindow = it.next();
        String secondWindow = it.next();
        driver.switchTo().window(secondWindow);
        String extractedText = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
        System.out.println(extractedText.split("at")[1].split(" ")[1]);
        String emailText = extractedText.split("at")[1].split(" ")[1];
        driver.switchTo().window(firstWindow);
        driver.findElement(By.name("username")).sendKeys(emailText);
        //driver.quit();

    }
}
