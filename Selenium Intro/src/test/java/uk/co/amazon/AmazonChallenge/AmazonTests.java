package uk.co.amazon.AmazonChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AmazonTests {

    public static WebDriver webDriver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupWebDriver() {
        webDriver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void searchForDogTreatsWithFilters() {
        webDriver.get("https://www.amazon.co.uk");
        AmazonHomePage amazonHomePage = new AmazonHomePage(webDriver);
        amazonHomePage.acceptCookies();
        amazonHomePage.inputSearchForDogTreatsFromHomePage("twotabsearchtextbox", "dog treats");
        SearchResultsPage searchResultsPage = amazonHomePage.searchForDogTreatsFromHomePage("nav-search-submit-button");
        assertThat("", searchResultsPage.confirmAvCustomerReviewSection("Avg. Customer Review"), is("Avg. Customer Review"));
        String confirmRatingFilter = searchResultsPage
                .filterResultsByBestRating("a-icon a-icon-star-medium a-star-medium-4")
                .confirmRatingFilter("a-link-normal s-navigation-item s-navigation-clear-link");
        assertThat("", confirmRatingFilter, is("Clear"));
        String confirmPriceFilter = searchResultsPage
                .filterResultsByLowestPrice("Up to £15")
                .confirmPriceFilter();
        assertThat("", confirmPriceFilter, is("Any Price"));
    }

    @Test
    public void findHowToReportSuspiciousActivity() {
        webDriver.get("https://www.amazon.co.uk");
        AmazonHomePage amazonHomePage = new AmazonHomePage(webDriver);
        amazonHomePage.acceptCookies();
        CustomerServicePage customerServicePage = amazonHomePage.navigateToCustomerServices("nav-xshop");
        assertThat("", customerServicePage.confirmCustomerServicePage(), is("Hello. What can we help you with?"));
        SuspiciousActivityResultsPage suspiciousActivityResultsPage = customerServicePage.selectReportSomethingSuspicious("Report Something Suspicious");
        assertThat("", suspiciousActivityResultsPage.confirmSuspiciousActivityResultsPage(""), is("Identifying Whether an Email, Phone Call, Text Message, or Webpage is from Amazon"));
        String confirmSearchForSuspiciousActivity = suspiciousActivityResultsPage
                .inputSearchForSuspiciousActivity("helpsearch","suspicious caller")
                .confirmSearchForSuspiciousActivity("Help Search Results");
        assertThat("", confirmSearchForSuspiciousActivity, is("Help Search Results"));

    }
}
