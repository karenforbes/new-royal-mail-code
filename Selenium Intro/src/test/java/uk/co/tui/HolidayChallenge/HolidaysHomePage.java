package uk.co.tui.HolidayChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HolidaysHomePage {

    private WebDriver webDriver;

    public HolidaysHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String confirmHolidaysHomePage(String linkText) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()=\"" + linkText + "\"]"))).getText();
    }

    public AllBeachHolidaysPage navigateToAllBeachHolidays(String linkText) {
        webDriver.findElement(By.xpath("//button[normalize-space()=\"" + linkText + "\"]")).click();
        return new AllBeachHolidaysPage(webDriver);
    }
    }
