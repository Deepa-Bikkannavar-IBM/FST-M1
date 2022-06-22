package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity2 {
    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        //String headerText= driver.findElement(By.cssSelector("h1.uagb-ifb-title")).getText();
        String headerText= driver.findElement(By.xpath("//h1[contains(text(),'Industry Experts')]")).getText();
        System.out.println("The header text is :"+headerText);
        if (headerText.equals("Learn from Industry Experts")){
            driver.close();
        }
    }
}
