package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity4_1 {

    public static void main(String args[]) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println("The title of the page is : " + driver.getTitle());
        WebElement textpath = driver.findElement(By.xpath("//a[@id='about-link']"));
        System.out.println("Text is :"+textpath.getText());
        driver.close();
    }
}
