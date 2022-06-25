package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("launched url");
        Reporter.log("Title of the page is "+driver.getTitle());

    }
    @BeforeMethod
    public void set(){
        driver.switchTo().defaultContent();
    }

    @Test(priority = 0)
    public void simpleAlertTest(){
        driver.findElement(By.id("simple")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Reporter.log("Success simple alert");
    }
    @Test(priority = 1)
    public void confirmAlertTest(){
        driver.findElement(By.id("confirm")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.accept();
        Reporter.log("Success confirm alert");
    }
    @Test(priority = 2)
    public void promptAlertTest(){
        driver.findElement(By.id("prompt")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.dismiss();
        alert2.sendKeys("message passed in textbox");
        Reporter.log("Success prompt alert");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
