package redbus;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AcceptInsecureCertsAndTakeScreenShot {
    public static void main(String[] args) throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        /*FirefoxOptions f = new FirefoxOptions();
        f.setAcceptInsecureCerts(true);*/

        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.get("http://expired.badssl.com/");

        TakesScreenshot ssDriver = (TakesScreenshot) driver;
        File src = ssDriver.getScreenshotAs(OutputType.FILE);
        File des = new File("D:\\Kranthi\\Selenium\\SeleniumJava\\src\\test\\java\\screenshots\\expired.png");
        FileUtils.copyFile(src, des);
        File des1 = new File("D:\\Kranthi\\Selenium\\SeleniumJava\\src\\test\\java\\screenshots\\expired1.jpg");
        FileUtils.copyFile(src, des1);

        driver.get("https://www.amazon.in/");
        WebElement searchBar = driver.findElement(By.xpath("//form[@id='nav-search-bar-form']"));
        File src2 = searchBar.getScreenshotAs(OutputType.FILE);
        File des2 = new File("D:\\Kranthi\\Selenium\\SeleniumJava\\src\\test\\java\\screenshots\\search.png");
        FileUtils.copyFile(src2, des2);
        driver.close();
    }
}
