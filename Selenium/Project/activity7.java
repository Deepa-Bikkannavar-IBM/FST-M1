package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity7 {
    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//a[text()='All Courses']")).click();

        List<WebElement> courses = driver.findElements(By.xpath("//h3[@class='entry-title']"));
        System.out.println("The total number of courses are :"+courses.size());

    }
}
