package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AlertPage {

    public AlertPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(css = "div[class='element-list collapse show'] li[id='item-1'] span[class='text']")
    public WebElement leftAlert;

    @FindBy(id = "alertButton")
    public WebElement toSeeAlert;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmButton;

    @FindBy(id = "confirmResult")
    public WebElement confirmResult;

    @FindBy(id = "promtButton")
    public WebElement InputName;

    @FindBy(id = "promptResult")
    public WebElement inputNameResult;
}
