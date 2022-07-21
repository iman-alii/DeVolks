package loginPositiveScenarios;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import base.testBase;

public class forgotPasswordScenario extends testBase {
    //From Login page click on "Ik ben mijn wachtwoord vergeten" and make sure user is navigated to correct page
    public void ForgotPassword() {
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

        //click on link "Ik ben mijn wachtwoord vergeten"
        basePage.WaitForElement(basePage.forgotPasswordBtn);
        WebElement ForgotPassword = basePage.GetElementBy(basePage.forgotPasswordBtn);
        ForgotPassword.click();

        //Make sure that user was Navigated to forgot password page
        String ActualPageTitle = basePage.GetPageTitle();
        String ExpectedPageTitle = "Wachtwoord vergeten";
        Assert.assertEquals(ExpectedPageTitle, ActualPageTitle);
    }
}