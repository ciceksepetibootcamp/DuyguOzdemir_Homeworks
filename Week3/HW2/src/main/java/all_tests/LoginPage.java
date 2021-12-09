package all_tests;

import io.cucumber.java.After;
import org.openqa.selenium.Keys;
import sun.security.mscapi.CPublicKey;
import utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;


    @Given("Navigate to Instagram")
    public void navigateToWebsite(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://www.instagram.com/");

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginForm > div > div:nth-child(1) > div > label > input")));
    }

    /* @positive
    Scenario Outline:
      Given Navigate to Instagram
      When User should enter user information "<userName>"
      And User should enter pass information "<password>"
      And User should click LogIn button.
      Then User should verify succeed logIn "Save your login information?"

      Examples:
        | userName                 | | password     |
        |testuserbootcamp@gmail.com| |Cs_123bcamp_123| */

    @FindBy(css = "#loginForm > div > div:nth-child(1) > div > label > input")
    public WebElement emailBox;

    @When("User should enter user information {string}")
    public void loginWithUsernameAndPassword(String userName){
        emailBox.sendKeys(userName);

    }
    @FindBy(css = "#loginForm > div > div:nth-child(2) > div > label > input")
    public WebElement passBox;

    @And("User should enter pass information {string}")
    public void loginWithUserpassAndPassword(String password){

        passBox.sendKeys(password);

    }
    @FindBy(css = "#loginForm > div > div:nth-child(3) > button")
    public WebElement signInButton;
    @And("User should click LogIn button.")
    public void clickSignInButton() throws InterruptedException {

        signInButton.click();
        Thread.sleep(5000);
    }

    @FindBy(css = "#react-root > div > div > section > main > div > div > div > section > div > div.olLwo")
    public WebElement popup;
    @Then("User should verify succeed logIn {string}")
    public void popupCheck(String succeedLogInMessage){

        Assert.assertEquals(succeedLogInMessage,popup.getText());

    }
    @FindBy(css = "#slfErrorAlert")
    public WebElement failedLogın;

    @Then("User should verify failed LogIn result {string}")
    public void failedLoginTest(String failedLogInMessage) {
        {
            boolean warningMessage = false;

            if (failedLogın != null)
            {
                warningMessage = true;
            }
            Assert.assertTrue(warningMessage);
        }
    }
    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(5000);
        Driver.closeDriver();
    }
    @FindBy(xpath ="//*[@class='XTCLo x3qfX']")
    public WebElement searchUserName;
    @Then("User should search someone's account {string}")
    public void searchUserAccount(String searchUser){
        searchUserName.sendKeys(searchUser);
        searchUserName.sendKeys(Keys.ENTER);
    }
}