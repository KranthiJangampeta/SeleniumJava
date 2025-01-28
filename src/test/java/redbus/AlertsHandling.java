package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class AlertsHandling {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);
        driver.findElement(By.id("alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        if(alertText.equals("Hello , share this practice page and share your knowledge")){
            Thread.sleep(2000);
            //below code is for handling alerts
            driver.switchTo().alert().accept();
        }

        // dismiss the alert
        driver.findElement(By.id("confirmbtn")).click();
        String alertText2 = driver.switchTo().alert().getText();
        if (alertText2.equals("Hello , Are you sure you want to confirm?")) {
            Thread.sleep(2000);
            driver.switchTo().alert().dismiss();
        }
        driver.quit();
    }
}