package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDowns {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        WebElement staticDd = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        // when your dropdown has tagname as Select. Then only use select class
        Select dropdown = new Select(staticDd);
        //option1
        dropdown.selectByIndex(2);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //option2
        dropdown.selectByValue("USD");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //option3
        dropdown.selectByVisibleText("Select");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        driver.quit();

    }
}
