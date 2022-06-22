package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity12_1 {

    public static void main(String args[]){
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.training-support.net/selenium/iframes");
        System.out.println("Title is :"+driver.getTitle());

        driver.switchTo().frame(0);

        WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading1.getText());

        WebElement button1= driver.findElement(By.id("actionButton"));
        System.out.println("Text of button :"+button1.getText());
        System.out.println("Color of button :"+button1.getAttribute("class").substring(12));
        button1.click();

        System.out.println("Text of button :"+button1.getText());
        System.out.println("Color of button :"+button1.getAttribute("class").substring(12));

        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[contains(@src,'frame2')]"))));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'frame2')]")));

        WebElement frameHeading2 = driver.findElement(By.xpath("//div[text()='This is the second frame!']"));
        System.out.println(frameHeading1.getText());

        WebElement button2= driver.findElement(By.id("actionButton"));
        System.out.println("Text of button :"+button1.getText());
        System.out.println("Color of button :"+button1.getAttribute("class").substring(12));
        button1.click();

        System.out.println("Text of button :"+button1.getText());
        System.out.println("Color of button :"+button1.getAttribute("class").substring(12));
    }
}
