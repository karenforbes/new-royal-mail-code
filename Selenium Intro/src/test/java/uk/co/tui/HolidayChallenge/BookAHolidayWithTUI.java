package uk.co.tui.HolidayChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BookAHolidayWithTUI {

    public static WebDriver webDriver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
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
    public void selectAHolidayReadyForBooking() throws InterruptedException {
        webDriver.get("https://www.tui.co.uk");
        TUIHomePage TUIHomePage = new TUIHomePage(webDriver);
        TUIHomePage.acceptCookies();
        HolidaysHomePage holidaysHomePage = TUIHomePage.navigateToHolidaysHomePage("HOLIDAYS");
        assertThat("", holidaysHomePage.confirmHolidaysHomePage("TUI Holidays"), is(("TUI HOLIDAYS")));
        AllBeachHolidaysPage allBeachHolidaysPage = holidaysHomePage.navigateToAllBeachHolidays("SEE ALL BEACH HOLIDAYS");
        assertThat("", allBeachHolidaysPage.confirmAllBeachHolidaysPage(), is(("HOLIDAY TYPES BY TUI")));
        LuxuryHolidaysPage luxuryHolidaysPage = allBeachHolidaysPage.navigateToLuxuryHolidaysPage();
        assertThat("", luxuryHolidaysPage.confirmLuxuryHolidaysPage("LUXURY HOLIDAYS"), is(("LUXURY HOLIDAYS")));
        LuxuryDealsPage luxuryDealsPage = luxuryHolidaysPage.navigateToAllLuxuryHolidays("ViewAllDeals");
        assertThat("", luxuryDealsPage.confirmLuxuryDealsPage("Luxury Deals"), is(("Luxury Deals")));
        String confirmResultsHaveFiltered = luxuryDealsPage
                .selectSortCriteria("TripAdvisor Rating")
                .confirmResultsHaveFiltered("CLEAR ALL FILTERS");
        assertThat("", confirmResultsHaveFiltered, is(("CLEAR ALL FILTERS")));
        SelectedHolidayPage selectedHolidayPage = luxuryDealsPage.selectHoliday("TUI SENSATORI Atlantica Caldera Palace");
        assertThat("", selectedHolidayPage.confirmHolidaySelected("TUI SENSATORI Atlantica Caldera Palace"), is(("TUI SENSATORI Atlantica Caldera Palace")));
        CustomiseHolidayPage customiseHolidayPage = selectedHolidayPage.selectHolidayToBook("Continue");
        assertThat("", customiseHolidayPage.confirmHolidayToCustomisePage("CUSTOMISE YOUR HOLIDAY"), is(("CUSTOMISE YOUR HOLIDAY")));
        HotelOptionsPage hotelOptionsPage = customiseHolidayPage.viewRoomUpgrades();
        assertThat("", hotelOptionsPage.confirmHotelOptionsPage("HOTEL OPTIONS"), is(("HOTEL OPTIONS")));


    }
}


