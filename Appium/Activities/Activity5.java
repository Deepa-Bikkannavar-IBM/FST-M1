package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
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

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OPPO Reno2 F");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity("com.google.android.ui.ConversationListActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void smsTest() {
        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("description(\"Start new conversation\")")));
        // Locate the button to write a new message and click it
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("description(\"Start new conversation\")")).click();

        // Enter the number to send message to
        String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";

        // Enter your own phone number
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(contactBoxLocator)));
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(contactBoxLocator)).sendKeys("9014842677");
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(contactBoxLocator)).sendKeys(Keys.ENTER);
       // ((AndroidDriver<WebElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")));

        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")).sendKeys("Hello from Appium");

        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("description(\"Send SMS\")")).click();

        String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(messageLocator)));

        String sentMessageText = driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
