package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity2 {

    public static void main(String args[]){

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println("The title of the page is : "+driver.getTitle());
        WebElement idpath = driver.findElement(By.id("about-link"));
        System.out.println("The text is : "+idpath.getText());


        WebElement classpath = driver.findElement(By.className("green"));
        System.out.println("The text is : "+classpath.getText());

        WebElement linkpath = driver.findElement(By.linkText("About Us"));
        System.out.println("The text is : "+linkpath.getText());

        WebElement csspath = driver.findElement(By.cssSelector("#about-link"));
        System.out.println("The text is : "+csspath.getText());

        driver.quit();
    }
}
