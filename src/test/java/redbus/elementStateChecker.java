package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class elementStateChecker {
    private static void checkElementState(String elementState){

        if(elementState.contains("1")){
            System.out.println("Element is enabled");
        }
        else if(elementState.contains("0.5")){
            System.out.println("Element is disabled");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        // checks if the element is enabled
        boolean elementState = driver.findElement(By.xpath("//div[@id='Div1']")).isEnabled();
        System.out.println(elementState);

        // checks if the element is disabled

        String styleProperty = driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style");
        checkElementState(styleProperty);
        //System.out.println(styleProperty);

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        Thread.sleep(2000);
        styleProperty = driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style");
        checkElementState(styleProperty);
        //System.out.println(styleProperty);
        driver.quit();

    }
}
