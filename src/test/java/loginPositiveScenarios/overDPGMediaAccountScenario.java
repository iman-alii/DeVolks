package loginPositiveScenarios;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import base.testBase;

public class overDPGMediaAccountScenario extends testBase {
    //From Login page click on "Over DPG Media account" and make sure user is navigated to correct page
    @Test
    public void OverDPGMediaAccount() {
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

        //click on link "Over DPG Media Account"
        basePage.WaitForElement(basePage.overDPGMediaAccount);
        WebElement OverDPGMedia = basePage.GetElementBy(basePage.overDPGMediaAccount);
        OverDPGMedia.click();

        //Make sure Title "Over DPG Account" is displayed
        basePage.VerifyTextPresent("Over DPG Media account");

    }
}