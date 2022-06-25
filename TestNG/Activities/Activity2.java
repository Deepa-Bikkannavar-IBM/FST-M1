package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test(priority = 0)
    public void test(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Target Practice");
    }
    @Test(priority = 1)
    public void test1(){
        WebElement black = driver.findElement(By.xpath("//button[text()='Black']"));
        Assert.assertEquals(black.getText(),"black");
    }
    @Test(priority = 2,enabled = false)
    public void test2(){
        System.out.println("Third test method");
    }
    @Test(priority = 4)
    public void test3(){
        throw new SkipException("Fourth test method is skipped");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
