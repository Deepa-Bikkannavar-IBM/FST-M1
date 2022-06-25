package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity3 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver= new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void test(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String successMsg = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(successMsg,"Welcome Back, admin");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
