package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class EcommerceAppEndToEnd {
    public static void main(String[] args) throws InterruptedException {
        //shortcut for formatting code ctrl+alt+L
        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //String expectedProduct = "Cucumber";
        String[] expectedproducts = {"Cucumber", "Beetroot", "Mango", "Orange"}; // ArrayList does not support contains, so we convert array list to List
        List<String> expectedproductsList = Arrays.asList(expectedproducts);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> productsList = driver.findElements(By.xpath("//h4[@class='product-name']"));
        System.out.println(productsList.size());
        boolean testStatus = false;
        for (int i = 0; i < productsList.size(); i++) {
            String pulledProduct = productsList.get(i).getText(); // when i=0, it pulls first elements and soon
            String[] newProduct = pulledProduct.split("-");
            String newTrimmedProduct = newProduct[0].trim(); //trim method removes leading and trailing spaces in a string
            //if(pulledProduct.contains(expectedProduct)){ // equals will compare each and every character, we did not use it
            if (expectedproductsList.contains(newTrimmedProduct)) {
                testStatus = true;
                System.out.println("I'm in  loop");
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                // break; // commented it as we need to select other products also
            }
        }
        Assert.assertTrue(testStatus);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        Thread.sleep(10000);
        Assert.assertEquals("Code applied ..!", driver.findElement(By.className("promoInfo")).getText());
        driver.quit();
    }
}