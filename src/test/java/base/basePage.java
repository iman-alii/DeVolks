package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class basePage {

    private final WebDriver driver; //define driver
    private WebDriverWait wait; //define wait func

    public basePage() { //Basic configuration
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe"); //just faced a problem with chromedriver 103 so I made this manual step to try driver 104
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15); //max of wait is 15sec
        openPage();
    }

    private void openPage() { //@BeforeTest
        driver.get("https:\\www.volkskrant.nl");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(basePage.IFrameId)));
        driver.switchTo().frame(basePage.IFrameId);
        wait.until(ExpectedConditions.visibilityOfElementLocated(basePage.acceptButton));
        driver.findElement(basePage.acceptButton).click();
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }

    public void cleanup() {//@AfterTest
        if (driver != null)
            driver.quit();
    }

    //-----------------------------------------------------------------------------------------------------------
    //UI Elements for Cookies
    public static By acceptButton = By.xpath("//button[contains(@class, 'pg-accept-button')]");
    public static String IFrameId = "sp_message_iframe_657795";
    //-----------------------------------------------------------------------------------------------------------
    // UI Elements for Login Page
    public static By goToLoginPage = By.xpath("//A[@class='pexi-tm-17059__btn '][text()='Log in als ABONNEE']");
    public By emailField = By.id("username");
    public By loginBtn = By.xpath("//BUTTON[@type='submit'][text()='Ga verder']");
    public By validationMessageforWrongCredentials = By.id("errorBlock-Email");
    public By validationMessageforMissingField = By.id("errorBlock-NotEmpty");
    public By passwordField = By.id("password");
    public By loginButton = By.xpath("//BUTTON[@type='submit'][text()='Log in']");
    public By overDPGMediaAccount = By.id("info-component_label");
    public By forgotPasswordBtn = By.xpath("//A[@href='https://login.dpgmedia.nl/password/reset?client_id=vk-selectives-web'][text()='Ik ben mijn wachtwoord vergeten']");
    public By doIhaveAnAccount = By.xpath("//SPAN[@class='link-component'][text()='Ik weet niet of ik al een account heb']");
    public By welkIsMijnEmail = By.xpath("//A[@href='https://login.dpgmedia.nl/subscription/lookup?client_id=vk-selectives-web&origin=IDENTIFY'][text()='Welk e-mailadres is aan mijn abonnement gekoppeld?']");
    public By loggedinBefore = By.xpath("//SPAN[@class='link-component'][text()='Ik logde eerder in via Facebook of Google']");
    public By services = By.xpath("//SPAN[@class='app-header-home__menuitem-text'][text()='Service']");
    public By loginFromServices = By.xpath("//H4[@class='menu-item__title'][text()='Inloggen']");
    public By incorrectPassword = By.id("errorBlock-OIDC-003");

    //-----------------------------------------------------------------------------------------------------------
    //UI Elements for Navigation & Search
    public By searchBtn = By.xpath("//SPAN[@class='app-header-home__menuitem-text'][text()='Zoeken']");
    public By columnisten = By.xpath("(//IMG[@class='card__image'])[1]");
    public By recensies = By.xpath("(//IMG[@class='card__image'])[2]");
    public By volkskeuken = By.xpath("(//IMG[@class='card__image'])[3]");
    public By searchFieldinput = By.xpath("//INPUT[@type='search']");
    public By zoekenButton = By.xpath("//INPUT[@type='submit']");
    public By searchResults = By.xpath("//P[@class='search-results']");

    // -----------------------------------------------------------------------------------------------------------
    public WebElement GetElementBy(By by) {
        return driver.findElement(by);
    } // get Element method
    public void WaitForElement(By by) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }//wait for an element to show
    public String GetUrl() {
        return driver.getCurrentUrl();
    } //get the page url
    public String GetPageTitle() {
        return driver.getTitle();
    } //get the page title
    public void VerifyTextPresent(String value) {
        driver.getPageSource().contains(value);
    } //get text and make sure it's visible
    public void GoBack() {
        driver.navigate().back();
    }//go back from page to a previous page
    public void WebDriverWait(){ wait = new WebDriverWait(driver,30);}

}
