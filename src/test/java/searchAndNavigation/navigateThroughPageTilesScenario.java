package searchAndNavigation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import base.testBase;

public class navigateThroughPageTilesScenario extends testBase {

    @Test
    public void NavigateThroughPageTiles() {

        //click on search Field
        basePage.WaitForElement(basePage.searchBtn);
        WebElement SearchField = basePage.GetElementBy(basePage.searchBtn);
        SearchField.click();

        //Go to Columnisten
        basePage.WaitForElement(basePage.columnisten);
        WebElement Columnisten = basePage.GetElementBy(basePage.columnisten);
        Columnisten.click();

        //Make Sure user has been Navigated to the right page
        String ActualColumnistenPage = basePage.GetUrl();
        String ExpectedColumnistenPage = "https://www.volkskrant.nl/columns";
        Assert.assertEquals(ExpectedColumnistenPage, ActualColumnistenPage);

        //Go back to search field
         basePage.GoBack();

        //Go to Recensies
        basePage.WaitForElement(basePage.recensies);
        WebElement Recensies = basePage.GetElementBy(basePage.recensies);
        Recensies.click();

        //Make Sure user has been Navigated to the right page
        String ActualRecensiesPage = basePage.GetUrl();
        String ExpectedRecensiesPage = "https://www.volkskrant.nl/recensies";
        Assert.assertEquals(ExpectedRecensiesPage, ActualRecensiesPage);

        //Go back to search field
        basePage.GoBack();

        //Go to Volkskeuken
        basePage.WaitForElement(basePage.volkskeuken);
        WebElement Volkskeuken = basePage.GetElementBy(basePage.volkskeuken);
        Volkskeuken.click();

        //Make Sure user has been Navigated to the right page
        String ActualVolkskeukenPage = basePage.GetUrl();
        String ExpectedVolkskeukenPage = "https://www.volkskrant.nl/volkskeuken";
        Assert.assertEquals(ExpectedVolkskeukenPage, ActualVolkskeukenPage);

    }
}