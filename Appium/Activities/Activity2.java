package Activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        // Set the Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OPPO Reno2 F");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Instantiate Appium Driver
       // driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testSearchAppium() {
        // Open page in browser
        driver.get("https://www.training-support.net/");

        // Wait for page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"About Us\"]")));

        // Get heading on page and print it
        String pageTitle = driver.findElement(AppiumBy.id("//android.widget.TextView[@text='Training Support']")).getText();
        System.out.println("Title on Homepage: " + pageTitle);

        // Find About Us button and click it
        WebElement aboutButton = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='About Us']"));
        aboutButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")));

        String newPageTitle = driver
                .findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']"))
                .getText();
        System.out.println("Title on new page: " + newPageTitle);

        Assert.assertEquals(pageTitle, "Training Support");
        Assert.assertEquals(newPageTitle, "About Us");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
