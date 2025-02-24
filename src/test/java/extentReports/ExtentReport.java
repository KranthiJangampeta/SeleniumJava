package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReport {
    ExtentReports extentReportObj;

    @BeforeClass
    public void extentReportConfiguration() {
        String path = System.getProperty("user.dir") + "/extentReports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Regression results");
        reporter.config().setDocumentTitle("Air India");

        extentReportObj = new ExtentReports();
        extentReportObj.attachReporter(reporter);
        extentReportObj.setSystemInfo("Tester", "Lokesh");
    }

    @Test
    public void extentTestOne() throws InterruptedException {
        extentReportObj.createTest("extentTestOne");
        System.setProperty("webdriver.chrome.driver", "D:\\Kranthi\\Selenium\\SeleniumJava\\src\\main\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        driver.close();
        //extentReportObj.flush();
    }

    @Test
    public void extentTest2() {
        ExtentTest test = extentReportObj.createTest("extentTest2");
        System.out.println("Failing this test");
        test.fail("Failing this test");
        // extentReportObj.flush();
    }

    @AfterClass
    public void extentFlush() {
        extentReportObj.flush();
    }
}
