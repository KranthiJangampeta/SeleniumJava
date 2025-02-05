package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get("https://the-internet.herokuapp.com/status_codes");
        //((JavascriptExecutor)driver).executeScript("window.scrollTo(0,100000)");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        SoftAssert softAssert = new SoftAssert();
        for (WebElement link : links) {
            String linkUrl = link.getAttribute("href");
            URL url = new URL(linkUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            softAssert.assertTrue(responseCode < 400, "Response code for link '" + linkUrl + "' is: " + responseCode);
        }
        softAssert.assertAll();
        driver.quit();
    }
}
