package searchAndNavigation;
import base.testBase;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class searchForKnownTextScenario extends testBase  {
    @Test
    public void SearchForKnownText() {
        //Go to SearchPage
        basePage.WaitForElement(basePage.searchBtn);
        WebElement SearchField = basePage.GetElementBy(basePage.searchBtn);
        SearchField.click();

        //enter random text in the search field
        basePage.WaitForElement(basePage.searchFieldinput);
        WebElement SearchInputField = basePage.GetElementBy(basePage.searchFieldinput);
        SearchInputField.sendKeys("volkskrant");

        //click on the zoeken button
        WebElement ZoekenButton = basePage.GetElementBy(basePage.zoekenButton);
        ZoekenButton.click();

        //make sure text is displayed "resulten voor "random text""
        basePage.WaitForElement(basePage.searchResults);
        String ActualSearchResults = basePage.GetElementBy(basePage.searchResults).getText();
        Assert.assertEquals("1000 resultaten voor volkskrant", ActualSearchResults);

        //Make sure page url contain the random next
        String ActualPageUrl = basePage.GetUrl();
        String ExpectedPageUrl = "https://www.volkskrant.nl/search?query=volkskrant";
        Assert.assertEquals(ExpectedPageUrl, ActualPageUrl);
    }
}