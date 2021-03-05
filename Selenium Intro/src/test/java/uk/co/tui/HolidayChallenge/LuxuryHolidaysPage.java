package uk.co.tui.HolidayChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LuxuryHolidaysPage {

    private WebDriver webDriver;

    public LuxuryHolidaysPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String confirmLuxuryHolidaysPage(String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()=\"" + linkText + "\"]"))).getText();
    }

    public LuxuryDealsPage navigateToAllLuxuryHolidays(String linkText) {
        webDriver.findElement(By.xpath("//a[@id=\"" + linkText + "\"]")).click();
        return new LuxuryDealsPage(webDriver);
    }

}
