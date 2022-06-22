package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity4 {

    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        String secondPopularcourse = driver.findElement(By.xpath("//*[@id='post-71']/div[2]/h3")).getText();
        System.out.println("The second most popular course is :" + secondPopularcourse);
        if(secondPopularcourse.equals("Email Marketing Strategies")){
            driver.close();
        }
    }

}
