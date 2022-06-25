package FST_Appium_project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class googlekeepActivity1 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //DesiredCapabilities is depreceted so use UiAutomator20options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OPPO Reno2 F");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        //server address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //device initialization
        driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void addNotesKeep(){
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/new_note_button")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title")));
        String title ="Appium";
        String textDesc = "Tool for mobile testing";
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys(title);
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys(textDesc);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"))));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/index_note_title")));
        String actualTitle = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();
        String actualTextDesc = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_text_description")).getText();

        Assert.assertEquals(actualTitle,title);
        Assert.assertEquals(actualTextDesc,textDesc);

    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
