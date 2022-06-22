package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity3 {
    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        String firstInfoBoxText = driver.findElement(By.cssSelector("h3.uagb-ifb-title")).getText();
        System.out.println("The header text is :" + firstInfoBoxText);
        if (firstInfoBoxText.equals("Actionable Training")){
            driver.close();
        }
    }
}
