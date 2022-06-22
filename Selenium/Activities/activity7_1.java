package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity7_1 {
    public  static void main(String args[]){
        WebDriver driver = new FirefoxDriver();

        driver.get(" https://training-support.net/selenium/dynamic-attributes");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//input[starts-with(@class,'username')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class,'password')]")).sendKeys("password");
        driver.findElement(By.xpath("//button[@onclick='signIn()']")).click();

         System.out.println(driver.findElement(By.id("action-confirmation")).getText());
         driver.close();
    }
}
