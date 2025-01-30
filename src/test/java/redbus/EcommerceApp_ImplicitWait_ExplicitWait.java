package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EcommerceApp_ImplicitWait_ExplicitWait {

    public static void main(String[] args) throws InterruptedException {
        //shortcut for formatting code ctrl+alt+L
        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //String expectedProduct = "Cucumber";
        String[] expectedproducts = {"Cucumber", "Beetroot", "Mango", "Orange"}; // ArrayList does not support contains, so we convert array list to List
        List<String> expectedproductsList = Arrays.asList(expectedproducts);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        AddProductsFromEkartApp obj = new AddProductsFromEkartApp();
        obj.addProducts(driver, expectedproductsList );
        //addProducts(driver, expectedproductsList); // use this line when the method is in same class and is delcared static

        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        //Thread.sleep(2000); // commented this as implicit wait is added
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
       // Thread.sleep(10000);

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        Assert.assertEquals("Code applied ..!", driver.findElement(By.className("promoInfo")).getText());
        driver.quit();
    }

}
