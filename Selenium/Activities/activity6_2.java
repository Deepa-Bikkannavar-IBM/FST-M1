package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity6_2 {
    public static void main(String args[]){

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://training-support.net/selenium/ajax");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//button[text()='Change Content']")).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"HELLO"));
        System.out.println(driver.findElement(By.id("ajax-content")).getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"I'm late"));
        System.out.println(driver.findElement(By.id("ajax-content")).getText());

        driver.close();

    }

}

