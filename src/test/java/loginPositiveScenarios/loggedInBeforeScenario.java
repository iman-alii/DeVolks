package loginPositiveScenarios;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import base.testBase;

public class loggedInBeforeScenario extends testBase {
    //From Login page click on "Ik logde eerder in via Facebook of Google" and make sure user is navigated to correct page
    @Test
    public void LoggedInBefore() {
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

        //click on link "Ik logde eerder in via Facebook of Google"
        basePage.WaitForElement(basePage.loggedinBefore);
        WebElement LoggedinBefore = basePage.GetElementBy(basePage.loggedinBefore);
        LoggedinBefore.click();

        //Make sure that user was Navigated to "the Ik weet niet of ik al een account heb" page
        String ActualPageTitle = basePage.GetPageTitle();
        String ExpectedPageTitle = "Inloggen | volkskrant.nl";
        Assert.assertEquals(ExpectedPageTitle, ActualPageTitle);

        //verify that text exist
        basePage.VerifyTextPresent("De inlogprocedure van de Volkskrant is aangepast. Het is niet meer mogelijk om in te loggen via Facebook of Google.");
    }
}