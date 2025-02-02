package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.internal.thread.IThreadFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandlingLinks {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.get("http://qaclickacademy.com/practice.php");
        Thread.sleep(10000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links present in the page: " + links.size());
        WebElement footer = driver.findElement(By.className("footer_top_agile_w3ls"));
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
        System.out.println("Number Of footer links: " + footerLinks.size());
        WebElement firstColumn = footer.findElement(By.xpath("//div[contains(@class,'footer_top_agile_w3ls')]/descendant::td[1]"));
        List<WebElement> firstColumnElements = firstColumn.findElements(By.tagName("a"));
        System.out.println("Number Of footer links: " + firstColumnElements.size());

        System.out.println("Below are the page titles:");
        //click on each link and print the title
        for (int i=1; i<firstColumnElements.size(); i++){

            String openLinkInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstColumnElements.get(i).sendKeys(openLinkInNewTab);
        }

        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> it = tabs.iterator();
        while(it.hasNext()){
            driver.switchTo().window(it.next());
            Thread.sleep(10000);
            System.out.println(driver.getTitle());
        }
        driver.quit();
    }
}
