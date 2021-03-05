package uk.gov.dwp.automation.PageObjectChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class GovWebsiteNavigationTests {

       public static WebDriver webDriver; {
       }

        @BeforeAll
        public static void setupClass () {
                // Downloads the latest WebDriver driver for Chrome and puts it onto the path
                WebDriverManager.chromedriver().setup();
        }

        // Runs before EACH test
        @BeforeEach
        public void setupWebDriver () {
                webDriver = new ChromeDriver();

        }

         //Runs after EACH test has finished
        @AfterEach
        public void tearDown () {
               webDriver.quit();
        }


        @Test
        public void UniversalCreditTests() {
           //always needs a protocol i.e https: otherwise the web page will not be found
           webDriver.get("https://gov.uk");
           //when we put new after the = sign it is taking a blue print of the gov homepage class and creating a new instance. New declares a new instance
           //data to the left of the = sign is declaring a variable. So the GovHomepage is assigning the instance to govHomePage
           GovHomePage govHomePage = new GovHomePage(webDriver);
           //govhomepage is here as the method acceptCookies is in that class
           govHomePage.acceptCookies();
           //To the left of the equals we are assigning what is happening to the new instance on the right of equals sign. Right is the action left a way of tracking
           BrowseBenefitPage browseBenefitPage = govHomePage.selectLinkFromPage("Benefits");
            //"" is reason why the test would fail i.e page title does not match.. Assert that our actual result matches our expectations
            assertThat("", browseBenefitPage.getPageTitle(), is("Browse: Benefits"));
           //this is a multi line statement. The line doesn't finish till ;.
            String UCPageSubTitle = browseBenefitPage
                   .selectUCLink("Universal Credit")
                   .getUCPageSubTitle("Browse: Universal Credit");
            assertThat("", UCPageSubTitle, is("Browse: Universal Credit"));
            UniversalCreditPage universalCreditPage = browseBenefitPage.selectUniversalCredit("universal-credit");
            assertThat("", universalCreditPage.getPageTitle(), is("Universal Credit"));
            //if I remove this .selectEligibility doesn't work
            String UCSubTitle = universalCreditPage
                    .selectEligibility("Eligibility")
                    .getUCSubTitle();
            assertThat("", UCSubTitle, is("Eligibility"));

        }
    @Test
    public void TaxCreditTests() {
        webDriver.get("https://gov.uk");
        GovHomePage govHomePage = new GovHomePage(webDriver);
        govHomePage.acceptCookies();
        BrowseBenefitPage browseBenefitPage = govHomePage.selectLinkFromPage("Benefits");
        // Assert that our actual result matches our expectations
        assertThat("", browseBenefitPage.getPageTitle(), is("Browse: Benefits"));
        String pageSubTitle = browseBenefitPage
                .selectTCLink("Tax credits")
                .getTCPageSubTitle("Browse: Tax credits");
        assertThat("", pageSubTitle, is("Browse: Tax credits"));
        TaxCreditCalculatorPage taxCreditCalculatorPage = browseBenefitPage.selectTaxCreditsCalculator("Tax credits calculator");
        assertThat("", taxCreditCalculatorPage.getPageTitle(), is("Tax credits calculator"));
        ActualTaxCreditCalculatorPage actualTaxCreditCalculatorPage = taxCreditCalculatorPage.selectStartNow();
        String pageSubTitle2 = actualTaxCreditCalculatorPage
               .getPageTitle("Tax credits calculator");
        assertThat("", actualTaxCreditCalculatorPage.getPageTitle("Tax credits calculator"), is("Tax credits calculator"));
    }
    @Test
    public void VisasAndImmigrationTests() {
        webDriver.get("https://gov.uk");
        GovHomePage govHomePage = new GovHomePage(webDriver);
        govHomePage.acceptCookies();
        BrowseVisasAndImmigrationPage browseVisasAndImmigrationPage = govHomePage.selectVisasAndImmigrationLink( "Visas and immigration");
        assertThat("", browseVisasAndImmigrationPage.getBrowseVisasAndImmigrationPageTitle(), is("Browse: Visas and immigration"));
        String pageSubTitle = browseVisasAndImmigrationPage
                .selectTravellingToUKLink("Travelling to the UK")
                .getBrowseTravellingToTheUKPageTitle();

    }
}
