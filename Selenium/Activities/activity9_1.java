package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class activity9_1 {

    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");
        Select select = new Select(driver.findElement(By.id("single-select")));

        select.selectByVisibleText("Option 2");
        select.selectByIndex(3);
        select.selectByValue("4");
        List<WebElement> selectList = select.getOptions();
        for (WebElement webElement : selectList) {
            System.out.println(webElement.getText());
        }
    }
}
