package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity8_2 {
    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");

        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'sortable')]/tbody/tr"));
        System.out.println("The total rows are : " + rows.size());

        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class,'sortable')]/tbody/tr[1]/td"));
        System.out.println("Total columns are :" + cols.size());

        System.out.println("Second row second col value is "+driver.findElement(By.xpath("//table[contains(@class,'sortable')]/tbody/tr[2]/td[2]")).getText());
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]")).click();
        System.out.println("Second row second col value is "+driver.findElement(By.xpath("//table[contains(@class,'sortable')]/tbody/tr[2]/td[2]")).getText());
        WebElement footer = driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        System.out.println("Table footer values: " + footer.getText());
        driver.close();
    }
    }
