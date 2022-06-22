package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity5_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());

        System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).isDisplayed());
        driver.findElement(By.xpath("//button[text()='Remove checkbox']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).isDisplayed());
        driver.close();
    }

}
