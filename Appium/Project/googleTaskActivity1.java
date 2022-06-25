package FST_Appium_project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.netty.handler.codec.http.HttpServerKeepAliveHandler;
import org.openqa.selenium.By;
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

public class googleTaskActivity1 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //DesiredCapabilities is depreceted so use UiAutomator20options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OPPO Reno2 F");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        //server address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //device initialization
        driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void addTasks()  {
        WebElement addtask = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab"));
        addtask.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/task_item_layout")));
        List<WebElement> taskList =  driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_item_layout"));
        System.out.println(taskList.size());
        for (WebElement webElement : taskList) {
            System.out.println(webElement.getAttribute("content-desc"));
        }



        Assert.assertTrue(taskList.get(2).getAttribute("content-desc").equals("Complete Activity with Google Tasks"));
        Assert.assertTrue(taskList.get(1).getAttribute("content-desc").equals("Complete Activity with Google Keep"));
        Assert.assertTrue(taskList.get(0).getAttribute("content-desc").equals("Complete the second Activity Google Keep"));
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
