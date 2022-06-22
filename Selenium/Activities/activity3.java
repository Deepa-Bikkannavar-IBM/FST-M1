package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity3 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");

        String pageTitle = driver.getTitle();
        System.out.println("The title of the page is :"+pageTitle);
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));

        firstName.sendKeys("Deepa");
        lastName.sendKeys("Bikk");

        driver.findElement(By.id("email")).sendKeys("fstTest@example.com");
        driver.findElement(By.id("number")).sendKeys("1234567890");
        driver.findElement(By.cssSelector(".ui.green.button")).click();
        driver.close();
    }
}
