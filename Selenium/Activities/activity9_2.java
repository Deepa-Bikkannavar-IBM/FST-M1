package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class activity9_2 {
    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");
        Select select = new Select(driver.findElement(By.id("multi-select")));


        select.selectByVisibleText("Javascript");
        select.selectByValue("node");
        select.selectByIndex(4);
        select.selectByIndex(5);
        select.selectByIndex(6);
        select.deselectByValue("node");
        select.deselectByIndex(7);
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> list = select.getAllSelectedOptions();
        for (WebElement webele : list){
            System.out.println(webele.getText());
        }

        select.deselectAll();
        System.out.println(select.getFirstSelectedOption().getText());

    }
}
