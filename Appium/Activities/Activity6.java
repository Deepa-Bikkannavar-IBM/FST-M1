package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OPPO Reno2 F");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium/lazy-loading");
    }

    @Test
    public void imageScrollTest() {
        WebElement pageTitle = driver.findElement(AppiumBy.className("android.widget.TextView"));
        wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));

        List<WebElement> numberOfImages = driver.findElements(AppiumBy.xpath("//android.view.View/android.view.View/android.widget.Image"));
        System.out.println("Number of image shown currently: " + numberOfImages.size());

        Assert.assertEquals(numberOfImages.size(), 4);

        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));

        numberOfImages = driver.findElements(AppiumBy.xpath("//android.view.View/android.view.View/android.widget.Image"));
        System.out.println("Number of image shown currently: " + numberOfImages.size());

        Assert.assertEquals(numberOfImages.size(), 4);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
