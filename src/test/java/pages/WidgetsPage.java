package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WidgetsPage {

    public WidgetsPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//div [@class='card mt-4 top-card'])[4]")
    public WebElement widgestButton;

    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-6']")
    public WebElement toolTipsButton;

    @FindBy(id = "toolTipButton")
    public WebElement toolTip;

    @FindBy(xpath = "//*[contains(text(),'You hovered over the Button')]")
    public WebElement toolInner;

    @FindBy(id = "toolTipTextField")
    public WebElement textField;

    @FindBy(xpath = "//*[contains(text(),'You hovered over the text field')]")
    public WebElement textInput;


}
