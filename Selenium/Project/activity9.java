package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class activity9 {
    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//a[text()='My Account']")).click();

        driver.findElement(By.xpath("//a[contains(@class,'login')]")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();

        driver.findElement(By.xpath("//a[text()='All Courses']")).click();
        driver.findElement(By.xpath("//*[@id='post-71']/div[2]/p[2]/a")).click();

        String lesson1 = driver.findElement(By.xpath("//*[@id='ld-expand-91']/div/a/div[2]")).getText();
        String lesson2 = driver.findElement(By.xpath("//*[@id='ld-expand-24186']/div/a/div[2]")).getText();
        Assert.assertEquals(lesson1, "Deliverability Of Your Emails");
        Assert.assertEquals(lesson1, "Improving & Designing Marketing Emails");

        driver.findElement(By.xpath("//*[@id='ld-expand-91']/div/a/div[2]")).click();
        driver.findElement(By.xpath("//div[text()='Mark Complete']")).click();

        driver.findElement(By.xpath("//*[@id='learndash_post_91']/div/div[3]/div[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//div[text()='Mark Complete']")).click();
        driver.findElement(By.xpath("//a[text()='Back to Course']")).click();

        driver.close();
    }
    }
