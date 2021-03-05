package uk.co.tui.HolidayChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TUIHomePage {

    private WebDriver webDriver;

    public TUIHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String acceptCookies() {
        webDriver.findElement(By.xpath("//button[normalize-space()='ACCEPT']")).click();
        return null;
    }

    public HolidaysHomePage navigateToHolidaysHomePage(String linkText) {
        webDriver.findElement(By.xpath("//span[normalize-space()=\"" + linkText + "\"]")).click();
        return new HolidaysHomePage(webDriver);
    }

}
