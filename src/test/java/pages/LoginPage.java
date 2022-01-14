package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
}


    @FindBy(id="user-name")
    public WebElement inputUserName;

    @FindBy(id="password")
    public WebElement inputPassword;


    @FindBy(name = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//title")
    public WebElement homePage;

    public void login(String userNameStr, String passwordStr) {
        inputUserName.sendKeys(userNameStr);
        inputPassword.sendKeys(passwordStr);
    }
    public void login() {
        loginButton.click();



    }
}
