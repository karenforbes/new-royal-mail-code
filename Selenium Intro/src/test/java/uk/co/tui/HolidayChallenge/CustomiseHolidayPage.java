package uk.co.tui.HolidayChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomiseHolidayPage {

    private WebDriver webDriver;

    public CustomiseHolidayPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String confirmHolidayToCustomisePage(String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()=\"" + linkText + "\"]"))).getText();

    }

    public HotelOptionsPage viewRoomUpgrades() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//span[contains(text(),'View all room upgrades')]")))).click();
        return new HotelOptionsPage(webDriver);
    }
}
