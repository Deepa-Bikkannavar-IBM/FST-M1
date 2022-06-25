package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {
    WebDriver driver;
    WebDriverWait wait;
   @Given("^User is on Login page$")
    public void User_Is_on_Loin_page(){
       driver = new FirefoxDriver();
       driver.get("https://www.training-support.net/selenium/login-form");
       wait = new WebDriverWait(driver, Duration.ofSeconds(20));
   }

   @When("^User enters username and password$")
    public void user_enters_user_and_password(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

   }
   @Then("^Read the page title and confirmation message$")
    public void Read_page_title_confirm_message(){
       String title = driver.getTitle();
       String message = driver.findElement(By.id("action-confirmation")).getText();
       System.out.println("title of the page is :"+title);
       System.out.println("Confirmation message is :"+message);
   }

   @And("^Close the Browser$")
    public void close_the_browser(){
       driver.quit();
   }
}
