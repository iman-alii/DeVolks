package loginNegativeScenarios;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import base.testBase;


public class loginWithWrongEmailScenario extends testBase {
	//Test Objective: Make sure that when user enter an e-mail that's not registered but with correct format xx@xx.xx
	// 1- login won't be successful  2- error message will be fired
	@Test
	public void LoginWithInvalidData () {
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

		//enter an e-mail with correct format but not registered
		String generatedString = RandomString.make(5);//generate random variable of 5 characters
		basePage.WaitForElement(basePage.emailField);
		WebElement EmailField = basePage.GetElementBy(basePage.emailField);
		basePage.GetElementBy(basePage.emailField).click();
		EmailField.sendKeys(generatedString+"@gmail.com");

		//click on Ga Verder
		basePage.WaitForElement(basePage.loginBtn);
		WebElement submitButtonElement =  basePage.GetElementBy(basePage.loginBtn);
		submitButtonElement.click();

		//Make sure user is not Navigated
		String ActualPageUrl = basePage.GetPageTitle();
		String ExpectedPageTitle = "Profiel maken | volkskrant.nl";
		Assert.assertEquals(ExpectedPageTitle, ActualPageUrl);
	}
}