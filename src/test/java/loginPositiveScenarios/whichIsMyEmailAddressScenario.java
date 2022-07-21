package loginPositiveScenarios;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import base.testBase;

public class whichIsMyEmailAddressScenario extends testBase {
    //From Login page click on "Welk e-mailadres is aan mijn abonnement gekoppeld?" and make sure user is navigated to correct page
    @Test
    public void WhichIsMyEmailAddress() {
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

        //click on link "Welk e-mailadres is aan mijn abonnement gekoppeld?"
        basePage.WaitForElement(basePage.welkIsMijnEmail);
        WebElement WelkIsMijnEmail = basePage.GetElementBy(basePage.welkIsMijnEmail);
        WelkIsMijnEmail.click();

        //Make sure that user was Navigated to the "Welk e-mailadres is aan mijn abonnement gekoppeld?" correct page
        String ActualPageTitle = basePage.GetPageTitle();
        String ExpectedPageTitle = "E-mailadres opvragen";
        Assert.assertEquals(ExpectedPageTitle, ActualPageTitle);

        //verify that text exist
        basePage.VerifyTextPresent("Welk e-mailadres is aan mijn abonnement gekoppeld?");

    }
}