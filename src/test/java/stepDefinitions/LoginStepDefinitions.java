package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import static junit.framework.TestCase.assertEquals;


public class LoginStepDefinitions {

    LoginPage loginPage= new LoginPage();
    String Password = ConfigurationReader.get("Password");

    @Given("user is on login page")
    public void user_is_on_login_page() {
        String url= ConfigurationReader.get("url1");
        Driver.getDriver().get(url);
    }



    @When("^the user logs in using username3 information")
    public void the_user_logs_in_using_username3_information()  {
        String username = ConfigurationReader.get("username3");

        loginPage.login(username,Password);

    }
    @When("^the user logs in using username2 information$")
    public void the_user_logs_in_using_username2_information()  {
        String username = ConfigurationReader.get("username2");
        loginPage.login(username,Password);
    }

    @When("^the user logs in using username1 information")
    public void the_user_logs_in_using_username1_information()  {
        String username = ConfigurationReader.get("username1");

        loginPage.login(username,Password);

    }


    @When("^the user logs in using username information")
    public void the_user_logs_in_using_username_information()  {
        String username = ConfigurationReader.get("username");

        loginPage.login(username,Password);

    }
    @And("^user clicks login button$")
    public void user_clicks_login_button() {
        BrowserUtils.waitForClickablility(loginPage.loginButton,5);
        loginPage.login();

    }

    @Then("^user should see homepage")
    public void user_should_see_homepage()  {


        String actualTitle =Driver.getDriver().getTitle() ;
        String expectedTitle="Swag Labs";

        BrowserUtils.waitForVisibility(actualTitle,10);

        assertEquals("Title did not match.", expectedTitle, actualTitle);
    }


    @Then("^user should see the error message$")
    public void user_should_see_the_error_message()  {
        String expectedMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals("Message did not match", expectedMessage,actualMessage );


    }

    @When("User enters userType {string}")
    public void user_enters_userType (String username) {
        loginPage.inputUserName.sendKeys(username);
    }
    @When("User enters password {string}")
    public void user_enters_password(String password) {
        loginPage.inputPassword.sendKeys(password);
    }



    }








