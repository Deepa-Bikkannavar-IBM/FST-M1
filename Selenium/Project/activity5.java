package Activities;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity5 {
    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        System.out.println("The title of my account page is :"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"My Account – Alchemy LMS");
        driver.close();

    }
}
