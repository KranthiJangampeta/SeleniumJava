package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AddProductsFromEkartApp {

    public static void addProducts(WebDriver driver, List<String> expectedproductsList){
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
    }
}
