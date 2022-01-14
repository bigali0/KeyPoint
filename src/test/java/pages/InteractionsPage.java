package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InteractionsPage {
    public InteractionsPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div [@class='card mt-4 top-card'])[5]")
    public WebElement Interactions;

    @FindBy(xpath = "//span[text()='Droppable']")
    public WebElement dropPable;

    @FindBy(id = "droppableExample-tab-simple")
    public WebElement simple;

    @FindBy(xpath = "//div[text()='Drag me']")
    public WebElement dragMe;

    @FindBy(id = "droppable")
    public WebElement dropHere;

}
