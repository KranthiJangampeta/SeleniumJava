package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class LocatorsPractice {
    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" ,"D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        //driver.navigate().to("https://www.redbus.in/");
/*        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);*/
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.id("name")).sendKeys("Lokesh");
        Thread.sleep(3000);
        String email = "LokeshTest@gmail.com";
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.className("form-check-input")).click();
        driver.findElement(By.id("mobile")).sendKeys("1234567890");
        String text = driver.findElement(By.tagName("h1")).getText();
        System.out.println(text);
        // LinkText methods/locator can only be used for elements with anchor tags

        //String text1 = driver.findElement(By.linkText("Subjects:")).getText();
        //System.out.println(text1);
        //driver.close();
        //getTitle(), getCurrentUrl()
        System.out.println("Title of the page is: " + driver.getTitle());
        System.out.println("Current URL is: " +driver.getCurrentUrl());

        System.out.printf("line1 ");
        System.out.print("line3 ");
        System.out.println("line2 ");





        driver.quit();
        //int a = 1/0;
        System.out.println("This is the end of the program");

    }
}