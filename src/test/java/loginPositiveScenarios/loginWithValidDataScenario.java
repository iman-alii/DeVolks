package loginPositiveScenarios;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import base.testBase;


public class loginWithValidDataScenario extends testBase {
    //Make sure that registered user can login properly with correct username and password
    @Test
    public void LoginWithValidData() throws InterruptedException {

        //Go to LoginPage through the Login Als Abonee button
        //basePage.WaitForElement(basePage.goToLoginPage);
        //WebElement LoginButtonHomePage = basePage.GetElementBy(basePage.goToLoginPage);
        //LoginButtonHomePage.click();

        //Go to LoginPage through the services --> Inloggen
        basePage.WaitForElement(basePage.services);
        WebElement ServicesButton = basePage.GetElementBy(basePage.services);
        ServicesButton.click();
        basePage.WaitForElement(basePage.loginFromServices);
        WebElement LoginFromServices = basePage.GetElementBy(basePage.loginFromServices);
        LoginFromServices.click();

        //Enter valid and registered e-mail address
        basePage.WaitForElement(basePage.emailField);
        WebElement emailElement = basePage.GetElementBy(basePage.emailField);
        emailElement.click();
        emailElement.sendKeys("iman.m.m.ali.a@gmail.com");

        //click on Ga verder
        basePage.WaitForElement(basePage.loginBtn);
        WebElement submitButtonElement = basePage.GetElementBy(basePage.loginBtn);
        submitButtonElement.click();

        //Enter Password
        basePage.WaitForElement(basePage.passwordField);
        WebElement passwordElement = basePage.GetElementBy(basePage.passwordField);
        passwordElement.click();
        passwordElement.sendKeys("@123Applle");


        //click on login button
        basePage.WaitForElement(basePage.loginButton);
        WebElement LoginButton = basePage.GetElementBy(basePage.loginButton);
        LoginButton.click();


        //Make sure that user has been navigated
        String ActualPageUrl = basePage.GetPageTitle();
        String ExpectedPageTitle = "";
        Assert.assertEquals(ExpectedPageTitle, ActualPageUrl);
    }
}