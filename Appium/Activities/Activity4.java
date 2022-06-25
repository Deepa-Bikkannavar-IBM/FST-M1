package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OPPO Reno2 F");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity("com.android.activities.PeopleActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void addContact() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("Create new contact")));
        driver.findElement(AppiumBy.id("Create new contact")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));

        WebElement firstName = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']"));
        WebElement lastName = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']"));
        WebElement phoneNumber = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']"));

        firstName.sendKeys("Aaditya");
        lastName.sendKeys("Varma");
        phoneNumber.sendKeys("9991284782");

        driver.findElement(AppiumBy.id("editor_menu_save_button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("toolbar_parent")));

        WebElement mobileCard = driver.findElement(AppiumBy.id("toolbar_parent"));
        Assert.assertTrue(mobileCard.isDisplayed());

        String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
