package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity12_3 {
    public static void main(String args[]){
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(" https://www.training-support.net/selenium/popups");
        System.out.println("Title is :"+driver.getTitle());

        WebElement button = driver.findElement(By.xpath("//button[contains(@class,'orange button')]"));
        System.out.println("popup msg is :"+button.getAttribute("data-tooltip"));

        button.click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        System.out.println("Successful login msg :"+driver.findElement(By.id("action-confirmation")).getText());
    }
}
