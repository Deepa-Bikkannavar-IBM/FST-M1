package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity10_1 {

    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get(" https://www.training-support.net/selenium/input-events");
        System.out.println("Title of the page is :"+driver.getTitle());

        Actions action = new Actions(driver);
        WebElement cube = driver.findElement(By.id("wrapD3Cube"));

        action.click(cube).build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());

        action.doubleClick(cube).build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());

        action.contextClick(cube).build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());

        driver.close();
    }
}
