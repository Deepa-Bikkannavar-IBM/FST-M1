package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class activity1 {

    public static void main(String args[]){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        String title=driver.getTitle();
        System.out.println("The title of the page is :"+title);
        if (title.equals("Alchemy LMS – An LMS Application"));
            driver.close();
    }
}
