package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

public class activity10_2 {
    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get(" https://www.training-support.net/selenium/input-events");
        System.out.println("Title of the page is :" + driver.getTitle());

        Actions action = new Actions(driver);
        WebElement pressedKey = driver.findElement(By.id("keyPressed"));
        action.sendKeys("D").build().perform();
        System.out.println(pressedKey.getText());

        action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        System.out.println(pressedKey.getText());

        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clip.getContents(null);
        try{
            String text = (String) contents.getTransferData(DataFlavor.stringFlavor);
            StringSelection sel = new StringSelection(text);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
            System.out.println(text);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        }

    }
}
