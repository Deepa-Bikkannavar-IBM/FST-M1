package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity1 {

    public static void main(String args[]){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        driver.quit();
    }
}
