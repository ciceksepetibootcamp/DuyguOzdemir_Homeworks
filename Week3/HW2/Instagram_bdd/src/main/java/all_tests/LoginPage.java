package all_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

        public WebDriver driver = Driver.getDriver();
        WebDriverWait wait;

        @Given("Navigate to Instagram")
        public void navigateToWebsite() {
            driver.get("https://www.instagram.com/");
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(1) > h1")));
        }

        @FindBy(css = "#loginForm > div > div:nth-child(1) > div > label > input")
        public WebElement emailBox;

        @When("User Should enter user information {string}")
         public void loginWithUsernameAndPassword(String userName){

         emailBox.sendKeys(userName);

    }
        @FindBy(css = "#loginForm > div > div:nth-child(2) > div > label > input")
        public WebElement passBox;

        @And("User Should enter pass information {string}")
        public void loginWithUserpassAndPassword(String password){

          passBox.sendKeys(password);

        }

        @FindBy(css = "#loginForm > div > div:nth-child(3) > button")
        public WebElement signInButton;
        @Then("User Should click LogIn button.")
        public void clickSignInButton() {
                signInButton.click();
        }

}
