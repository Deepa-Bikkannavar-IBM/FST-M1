package FST_Appium_project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.checkerframework.checker.units.qual.A;
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
import java.util.List;

public class googleChromeActivity1 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //DesiredCapabilities is depreceted so use UiAutomator20options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OPPO Reno2 F");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //server address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //device initialization
        driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void test1(){
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.android.chrome:id/coordinator")));
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(UiScrollable+".flingForward()"));

        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(UiScrollable+".scrollIntoView(text(\"Elements get added at run time\"))")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        List<WebElement> list = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View"));
        for (int i=1;i<=list.size();i++){
            String taskName = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View["+i+"]/android.widget.TextView")).getText();
            System.out.println(taskName);

        }


        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add tasks to list']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Clear List')]")).click();


        //android.view.View[contains(@content-desc,'To-Do List')]
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
