package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity8_1 {
    public static void main(String args[]){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");

        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr"));
        System.out.println("The total rows are : "+rows.size());

        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[1]/td"));
        System.out.println("Total columns are :"+cols.size());

        for(int i=1;i<=cols.size();i++){
            System.out.println("cell"+i+":"+ driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td["+i+"]")).getText());

        }
        System.out.println("Second row second col value is "+driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[2]/td[2]")).getText());
        driver.close();
    }
}
