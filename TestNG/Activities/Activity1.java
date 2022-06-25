package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= new FirefoxDriver();
        driver.get(" https://www.training-support.net");
    }

    @Test
    public void test(){
        System.out.println("Title is :"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Training Support");

        WebElement aboutUsLink = driver.findElement(By.id("about-link"));
        aboutUsLink.click();
        System.out.println("New title : "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"About Training Support");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
