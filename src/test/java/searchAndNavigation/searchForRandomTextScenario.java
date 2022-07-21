package searchAndNavigation;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Test;
import base.testBase;
import org.openqa.selenium.WebElement;

public class searchForRandomTextScenario extends testBase {
    @Test
    public void SearchForRandomText () {
        //Go to SearchPage
        basePage.WaitForElement(basePage.searchBtn);
        WebElement SearchField = basePage.GetElementBy(basePage.searchBtn);
        SearchField.click();

        //enter random text in the search field
        String generatedString = RandomString.make(5);
        basePage.WaitForElement(basePage.searchFieldinput);
        WebElement SearchInputField = basePage.GetElementBy(basePage.searchFieldinput);
        SearchInputField.sendKeys(generatedString);

        //click on the zoeken button
        WebElement ZoekenButton = basePage.GetElementBy(basePage.zoekenButton);
        ZoekenButton.click();

        //make sure text is displayed "resulten voor "random text""
        basePage.WaitForElement(basePage.searchResults);
        String ActualSearchResults = basePage.GetElementBy(basePage.searchResults).getText();
        Assert.assertEquals("0 resultaten voor "+generatedString,ActualSearchResults);

        //Make sure page url contain the random text
        String ActualPageUrl = basePage.GetUrl();
        String ExpectedPageUrl = "https://www.volkskrant.nl/search?query="+generatedString;
        Assert.assertEquals(ExpectedPageUrl,ActualPageUrl);

    }
}
