package tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InteractionsPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class InteractionsTest {

    InteractionsPage interactionsPage=new InteractionsPage();

    @Before
    public void setUpMethod() {

       // Driver.getDriver().manage timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        BrowserUtils.waitFor(3000);
        Driver.getDriver().quit();
    }

    @Test
    public void interactionsTest() {

        String url = ConfigurationReader.get("url2");
        Driver.getDriver().get(url);

        Actions act =  new Actions(Driver.getDriver());

        System.out.println("==========clicking Interactions ===================");

        interactionsPage.Interactions.click();

        System.out.println("==========clicking Droppable with JSExc. ===========");

        BrowserUtils.clickWithJS(interactionsPage.dropPable);

        BrowserUtils.waitFor(3);

        interactionsPage.simple.click();

        System.out.println("==========Clicked hold and moved ===================");

        BrowserUtils.waitForVisibility(interactionsPage.dragMe,5);
        WebElement source = interactionsPage.dragMe;
        WebElement target = interactionsPage.dropHere;
        act.clickAndHold(source).pause(3).
                moveToElement(target).pause(2).
                release().build().perform();


    //   act.dragAndDrop(source,target).build().perform();

        System.out.println("==========verified ===================");


        String expectedTargetMess ="Dropped!";
        Assert.assertTrue(target.getText().contains("Dropped!"));
        System.out.println(target.getText());


    }

}
