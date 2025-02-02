package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatePicker {
    public static void main(String[] args) throws InterruptedException, ParseException {
        String day = "19";
        String month = "December";
        String year = "2023";
        String[] expectedDateStringArray = {year, getMonthName(month), day};

        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.className("react-date-picker__inputGroup")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        driver.findElement(By.xpath("//abbr[text()='" + month + "']/..")).click();
        driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();
        String actualDate = driver.findElement(By.xpath("//input[@name='date']")).getAttribute("value");
        System.out.println(actualDate);
        String[] actualDateStringArray = actualDate.split("-");
        for (int i = 0; i < actualDateStringArray.length; i++) {
            Assert.assertEquals(actualDateStringArray[i], expectedDateStringArray[i]);
        }
        driver.close();
    }

    public static String getMonthName(String month) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        SimpleDateFormat outptFormat = new SimpleDateFormat("MM");
        Date date = inputFormat.parse(month);
        String monthNumber = outptFormat.format(date);
        System.out.println("monthNumber is : " + monthNumber);
        return monthNumber;
    }

}
