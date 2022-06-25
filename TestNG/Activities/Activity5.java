package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver= new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void titleTest(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Target Practice");
    }
    @Test(groups = {"HeaderTests"})
    public void headerTest1(){
        String headertxt = driver.findElement(By.id("third-header")).getText();
        Assert.assertEquals(headertxt,"Third header");
    }
    @Test(groups = {"HeaderTests"})
    public void headerTest2(){
        WebElement header5 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header5.getCssValue("color"), "rgb(251, 189, 8)");
    }

    @Test(groups = {"ButtonTests"})
    public void buttonTest1(){
        String buttontxt = driver.findElement(By.xpath("//button[contains(@class,'olive')]")).getText();
        Assert.assertEquals(buttontxt,"Olive");
    }
    @Test(groups = {"ButtonTests"})
    public void buttonTest2(){
       // String buttonColor = driver.findElement(By.xpath("//div[@class='column'][2]/div[3]/button")).getText();
       // Assert.assertEquals(buttonColor,"Brown");
        WebElement button2 = driver.findElement(By.xpath("//div[@class='column'][2]/div[3]/button"));
        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}
