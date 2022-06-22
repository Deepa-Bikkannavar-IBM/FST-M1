package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity4_3 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println(driver.getTitle());

        String thirdHeader= driver.findElement(By.id("third-header")).getText();
        System.out.println("The third header is :"+thirdHeader);

        String fifthHeader= driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
        System.out.println("The fifth header color is :"+fifthHeader);

        String violetButtonClasses = driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class");
        System.out.println("Violet button's classes are: " + violetButtonClasses);

        String greyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
        System.out.println("The grey button's text is: " + greyButton);

        driver.close();
    }
}
