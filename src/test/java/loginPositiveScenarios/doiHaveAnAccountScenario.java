package loginPositiveScenarios;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import base.testBase;

public class doiHaveAnAccountScenario extends testBase {
//From Login page click on "Ik weet niet of ik al een account heb"

    @Test
    public void DoiHaveAnAccount() {
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

        //click on link "Ik weet niet of ik al een account heb"
        basePage.WaitForElement(basePage.doIhaveAnAccount);
        WebElement DoIhaveAnAccount = basePage.GetElementBy(basePage.doIhaveAnAccount);
        DoIhaveAnAccount.click();

        //Make sure that user was Navigated to the "Ik weet niet of ik al een account heb"
        String ActualPageTitle = basePage.GetPageTitle();
        String ExpectedPageTitle = "Inloggen | volkskrant.nl";
        Assert.assertEquals(ExpectedPageTitle, ActualPageTitle);

        //verify that text exist
        basePage.VerifyTextPresent("Vul hierboven uw e-mailadres in en klik op 'Ga verder'. Zo kunnen we nagaan of u al een account heeft.");

    }
}