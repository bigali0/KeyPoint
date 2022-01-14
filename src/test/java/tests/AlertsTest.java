package tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AlertPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;


public class AlertsTest {

    AlertPage alertPage = new AlertPage();

    @Before
    public void setUpMethod() {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void afterMethod() throws InterruptedException {

        //BrowserUtils.waitFor(3000);
        Driver.getDriver().quit();
    }



    @Test
    public void alertTest() {

        String url = ConfigurationReader.get("url");
        Driver.getDriver().get(url);


        //clicks to see all the alert buttons
        alertPage.leftAlert.click();

        System.out.println("==============first alert to handle=================");

        alertPage.toSeeAlert.click();

        Alert alert= Driver.getDriver().switchTo().alert();

        System.out.println("Alert1 = " +alert.getText());
        alert.accept();
        BrowserUtils.waitForClickablility(alertPage.timerAlertButton,5);

        System.out.println("==============second alert to handle=================");

        alertPage.timerAlertButton.click();
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert1 = Driver.getDriver().switchTo().alert();
            System.out.println("Alert2 = " +alert1.getText());
            alert.accept();
            Assert.assertTrue(alert1.getText().contains("This alert appeared after 5 seconds"));
        } catch (Exception e) {
            //exception handling
        }


        System.out.println("==============third alert to handle=================");

        alertPage.confirmButton.click();
        System.out.println("Alert3 =" +alert.getText());
        alert.accept();
        System.out.println(alertPage.confirmResult.getText());


        System.out.println("==============fourth alert to handle=================");
        alertPage.InputName.click();
        System.out.println("Alert4 =" +alert.getText());
        alert.sendKeys("Ahmet");
        alert.accept();
        System.out.println(alertPage.inputNameResult.getText());



    }


}
