package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.WidgetsPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class WidgetsTest {

    WidgetsPage widgetsPage=new WidgetsPage();
    @Before
    public void setUpMethod() {

        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        BrowserUtils.waitFor(3000);
        Driver.getDriver().quit();
    }

    @Test
    public void widgetsToolTipTest() {

        String url = ConfigurationReader.get("url2");
        Driver.getDriver().get(url);

        widgetsPage.widgestButton.click();

        //Using BrowserUtil JSExc

        BrowserUtils.clickWithJS(widgetsPage.toolTipsButton);

        WebElement toolTip = widgetsPage.toolTip;

        // Use action class from BrowserUtils to mouse hover
        BrowserUtils.hover(toolTip);


        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        // To get the tool tip text and assert
        String text= Driver.getDriver().findElement(By.xpath("//*[contains(text(),'You hovered over the Button')]")).getText();
        System.out.println("Text-->"+text);
        String expextedText="You hovered over the Button";

        Assert.assertEquals("you did not hover over",expextedText,text);

    }
    @Test
    public void textFieldTest(){
        String url = ConfigurationReader.get("url2");
        Driver.getDriver().get(url);

        widgetsPage.widgestButton.click();

        //clicking toolTips button with the help of JSExc.

        BrowserUtils.clickWithJS(widgetsPage.toolTipsButton);

        WebElement toolText = widgetsPage.textField;

        // Use action class from BrowserUtils to mouse hover
        BrowserUtils.hover(toolText);

        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        // To get the  text and assert
        String textBox= Driver.getDriver().findElement(By.xpath("//*[contains(text(),'You hovered over the text field')]")).getText();
        System.out.println("Text-->"+textBox);
        String expextedText="You hovered over the text field";

        Assert.assertEquals("you did not hover over",expextedText,textBox);






    }
    }
