package loginNegativeScenarios;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import base.testBase;


public class loginWithInValidEmailScenario extends testBase {
//Test Objective: Make sure that when user enter an e-mail with wrong format e.g string without @ or .
// 1- login won't be successful  2- error message will be fired
	@Test
	public void LoginWithInValidEmail () {
		//Go to LoginPage through the Login Als Abonee button
		//basePage.WaitForElement(basePage.goToLoginPage);
		//WebElement LoginButtonHomePage = basePage.GetElementBy(basePage.goToLoginPage);
		//LoginButtonHomePage.click();

//Go to LoginPage through services --> Inloggen
		basePage.WaitForElement(basePage.services);
		WebElement ServicesButton = basePage.GetElementBy(basePage.services);
		ServicesButton.click();
		basePage.WaitForElement(basePage.loginFromServices);
		WebElement LoginFromServices = basePage.GetElementBy(basePage.loginFromServices);
		LoginFromServices.click();

	    // enter an e-mail with wrong format
		String generatedString = RandomString.make(5);
		WebElement emailElement =  basePage.GetElementBy(basePage.emailField);
		emailElement.sendKeys(generatedString);

		//click on Ga Verder
		WebElement submitButtonElement =  basePage.GetElementBy(basePage.loginBtn);
		submitButtonElement.click();

		//Make sure that user was not navigated
		String ActualPageTitle = basePage.GetPageTitle();
		String ExpectedPageTitle = "Inloggen | volkskrant.nl";
		Assert.assertEquals(ExpectedPageTitle, ActualPageTitle);

		//Check validation message is displayed
		basePage.WaitForElement(basePage.validationMessageforWrongCredentials);
		String actualWrongEmailValidation = basePage.GetElementBy(basePage.validationMessageforWrongCredentials).getText();
		Assert.assertEquals("Dit is geen geldig e-mailadres", actualWrongEmailValidation);

	}
}