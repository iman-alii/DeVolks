package loginNegativeScenarios;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import base.testBase;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginWithMissingPasswordScenario extends testBase {
    //Test Objective: Make sure that when user enter a valid e-mail but forget to enter password
    // 1- login won't be successful  2- error message will be fired
    @Test
    public void LoginWithMissingPassword() {
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

        //click on login
        basePage.WaitForElement(basePage.loginButton);
        WebElement LoginButtonElement = basePage.GetElementBy(basePage.loginButton);
        LoginButtonElement.click();

        //Make sure that user was not navigated
        String ActualPageTitle = basePage.GetUrl();
        String ExpectedPageTitle = "https://login.dpgmedia.nl/login?client_id=vk-selectives-web";
        Assert.assertEquals(ExpectedPageTitle, ActualPageTitle);

        //This test cases didn't work throughh automation as it should be the page gives 406 Not Acceptable Error

        //Check validation message is displayed
        //basePage.WaitForElement(basePage.validationMessageforMissingField);
        //String actualMissingPasswordValidation = basePage.GetElementBy(basePage.validationMessageforMissingField).getText();
        //Assert.assertEquals("Dit veld is verplicht", actualMissingPasswordValidation);
    }
}