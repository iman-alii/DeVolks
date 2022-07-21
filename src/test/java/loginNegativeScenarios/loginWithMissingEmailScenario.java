package loginNegativeScenarios;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import base.testBase;


public class loginWithMissingEmailScenario extends testBase {
	//Test Objective: Make sure that when user forget to enter e-mail address
	// 1- login won't be successful  2- error message will be fired
	@Test
	public void LoginWithMissingEmail () {
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

		//enter empty email address
		basePage.WaitForElement(basePage.emailField);
		WebElement emailElement =  basePage.GetElementBy(basePage.emailField);
		emailElement.click();
		emailElement.sendKeys("");

		//click on Ga verder button
		basePage.WaitForElement(basePage.loginBtn);
		WebElement submitButtonElement =  basePage.GetElementBy(basePage.loginBtn);
		submitButtonElement.click();

		//Make sure that user was not navigated
		String ActualPageUrl = basePage.GetPageTitle();
		String ExpectedPageTitle = "Inloggen | volkskrant.nl";
		Assert.assertEquals(ExpectedPageTitle, ActualPageUrl);

		//Check validation message is displayed
		basePage.WaitForElement(basePage.validationMessageforMissingField);
		String actualMissingEmailValidation = basePage.GetElementBy(basePage.validationMessageforMissingField).getText();
		Assert.assertEquals("Dit veld is verplicht", actualMissingEmailValidation);


	}
}