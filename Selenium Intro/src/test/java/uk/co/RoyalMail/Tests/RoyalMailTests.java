package uk.co.RoyalMail.Tests;

import org.junit.jupiter.api.Test;
import uk.co.RoyalMail.PageObjects.ChooseStampsPage;
import uk.co.RoyalMail.PageObjects.GoogleHomePage;
import uk.co.RoyalMail.PageObjects.RoyalMailHomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RoyalMailTests extends TestBasePage{

    @Test
    public void buyPostageOnlineFromRoyalMail() {
                GoogleHomePage googleHomePage = new GoogleHomePage(webDriver);
        googleHomePage.acceptGoogleCookies()
                .confirmGoogleHomePage()
                .inputSearchForRoyalMail("royal mail")
                .confirmSearchResults("Royal Mail");
        RoyalMailHomePage royalMailHomePage = googleHomePage.navigateToRoyalMailHomePage("Royal Mail | Royal Mail Group Ltd");
        royalMailHomePage.acceptCookies();
        assertThat("", royalMailHomePage.confirmRoyalMailHomePage(), is(("Track an Item")));
        ChooseStampsPage chooseStampsPage = royalMailHomePage.navigateToChooseStampsPage("Stamps and supplies");
        chooseStampsPage.confirmChooseStampsPage("Only Fools and Horses")
                .selectTypeOfStamps("Buy now")
                .selectStampsToPurchase("Only Fools and Horses Presentation Pack");


    }
}


