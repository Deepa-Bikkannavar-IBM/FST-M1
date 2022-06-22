package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity8 {
    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//a[text()='Contact']")).click();

        driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id='wpforms-8-field_1']")).sendKeys("test@example.com");
        driver.findElement(By.xpath("//textarea[@id='wpforms-8-field_2']")).sendKeys("Selenium testing");
        driver.findElement(By.xpath("//button[@id='wpforms-submit-8']")).click();

        String successMsg= driver.findElement(By.xpath("//*[@id='wpforms-confirmation-8']/p")).getText();
        System.out.println(successMsg);
        if(successMsg.equals("Thanks for contacting us! We will be in touch with you shortly.")){
            System.out.println("Successfully submitted the response ");
            driver.close();
        }
    }

    }
