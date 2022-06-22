package Activities;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity6 {

    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//a[text()='My Account']")).click();

        driver.findElement(By.xpath("//a[contains(@class,'login')]")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();

        WebElement ele= driver.findElement(By.xpath("//h3[text()='Your Courses']"));
        if(ele.isDisplayed()){
            System.out.println("Successfully logged in : User is on home page");
            driver.close();
        }
        else{
            System.out.println("Unsuccesful login");
        }

    }
}
