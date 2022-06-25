package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //DesiredCapabilities is depreceted so use UiAutomator20options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OPPO Reno2 F");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.coloros.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.noReset();

        //server address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //device initialization
        driver = new AndroidDriver(serverURL,options);
    }
    @Test
    public void multiplyTest(){
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/clr")).click();
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/eq")).click();
        String result = driver.findElement(AppiumBy.id("com.coloros.calculator:id/result")).getText();
        Assert.assertEquals(result,"45");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
